package no.sintef.bvr.planner.ui;

import java.io.ByteArrayOutputStream;
import no.sintef.bvr.planner.repository.Repository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.PlanningProblemBuilder;
import no.sintef.bvr.planner.Settings;
import static no.sintef.bvr.planner.ui.Display.*;
import static no.sintef.bvr.planner.Status.*;
import no.sintef.bvr.planner.repository.FakeFileSystem;
import no.sintef.bvr.planner.repository.FakeOperatorsReader;
import no.sintef.bvr.planner.repository.PlanWriter;
import no.sintef.bvr.planner.repository.PropertiesStateReader;
import static no.sintef.bvr.planner.ui.Parameter.*;
import static no.sintef.bvr.planner.ui.TestController.GOAL_TEXT;
import static no.sintef.bvr.planner.ui.TestController.ORIGIN_TEXT;
import static org.junit.Assert.*;
import org.junit.Test;


class TestableController extends Controller {

    private final FakeFileSystem fileSystem;
    private final ByteArrayOutputStream output;
    private String goalLocation;
    private String originLocation;
    private Operators operators;
    private String operatorLocation;
    private String planLocation;

    public TestableController(Operators operators) {
        this.fileSystem = new FakeFileSystem();
        this.output = new ByteArrayOutputStream();
        setGoalFile(Settings.DEFAULT_GOAL_LOCATION, GOAL_TEXT);
        setOriginFile(Settings.DEFAULT_ORIGIN_LOCATION, ORIGIN_TEXT);
        setOperatorsFile(Settings.DEFAULT_OPERATORS_LOCATION, "whatever");
        planLocation = Settings.DEFAULT_PLAN_LOCATION;
        this.operators = operators;
        
    }

    public void setGoalFile(String location, String content) {
        goalLocation = location;
        fileSystem.define(location, content);
    }

    public void setOriginFile(String location, String content) {
        originLocation = location;
        fileSystem.define(location, content);
    }
    
    public void setOperatorsFile(String location, String content) {
        operatorLocation = location;
        fileSystem.define(location, content);
    }

    public void setPlanFile(String location) {
        planLocation = location;
    }

    @Override
    protected Repository configureRepositoryWith(Settings settings) {
        return new Repository(
                new PropertiesStateReader(settings.getOriginLocation(), fileSystem),
                new PropertiesStateReader(settings.getGoalLocation(), fileSystem),
                new FakeOperatorsReader(operators),
                new PlanWriter(settings.getPlanLocation()));
    }

    @Override
    protected Display configureDisplay() {
        return new Display(output);
    }
    
    String getOutput() {
        return output.toString();
    }

}


public class TestController {

    public static final String ORIGIN_TEXT
            = "f1: ?\n"
            + "f2: ?\n"
            + "f3: ?\n";
    public static final String GOAL_TEXT
            = "f1: +\n"
            + "f2: +\n"
            + "f3: -\n";

    private final PlanningProblem problem;
    private final TestableController controller;

    public TestController() {
        problem = prepareProblem();
        controller = new TestableController(problem.getOperators());
    }

    private PlanningProblem prepareProblem() {
        PlanningProblemBuilder builder = new PlanningProblemBuilder();
        builder.setFeatureCount(3);
        builder.setOrigin(PENDING, PENDING, PENDING);
        builder.setGoal(POSITIVE, POSITIVE, NEGATIVE);
        builder.addStandardOperators();
        return builder.getResult();
    }

    @Test
    public void shouldReportStoringThePlan() {
        final String planLocation = "my_plan.txt";

        executeWith(PLAN.shortName(), planLocation);

        verifyOutputContains(PLAN_STORED, planLocation);
    }

    @Test
    public void shouldReportLoadingTheOrigin() {
        final String originLocation = "start.state";
        controller.setOriginFile(originLocation, ORIGIN_TEXT);

        executeWith(ORIGIN.shortName(), originLocation);

        verifyOutputContains(ORIGIN_SUCCESSFULLY_LOADED, originLocation);
    }

    @Test
    public void shouldReportLoadingTheGoal() {
        final String goalLocation = "goal.state";
        controller.setGoalFile(goalLocation, GOAL_TEXT);

        executeWith(GOAL.shortName(), goalLocation);

        verifyOutputContains(GOAL_SUCCESSFULLY_LOADED, goalLocation);
    }

    @Test
    public void shouldReportLoadingOperators() {
        final String operatorLocation = "my-operators.txt";
        controller.setOperatorsFile(operatorLocation, "whatever");

        executeWith(OPERATORS.shortName(), operatorLocation);

        verifyOutputContains(OPERATORS_SUCCESSFULLY_LOADED, operatorLocation);
    }

    @Test
    public void shouldReportAboutFilesThatDoNotExist() {
        final String missingFile = "a-file.that-do-not-exist";
        controller.execute(ORIGIN.shortName(), missingFile);

        verifyOutputContains(UNABLE_TO_LOAD_FILE, missingFile);
    }

    @Test
    public void shouldReportUnknownParameters() {
        final String unknownParameter = "--unknown-parameter";

        controller.execute(unknownParameter, "blablablablah!");

        verifyOutputContains(UNKNOWN_ARGUMENT, unknownParameter);
    }

    @Test
    public void shouldReportMissingParameters() {
        controller.execute(GOAL.shortName());

        verifyOutputContains(MISSING_ARGUMENT, GOAL.shortName());
    }

    private void executeWith(String... commandLine) {
        controller.execute(commandLine);
    }

    private void verifyOutputContains(String format, Object... values) {
        String patternText = String.format(format, values);
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(controller.getOutput());
        String error = String.format("Could not match pattern '%s' in text '%s'", patternText, controller.getOutput());
        assertTrue(error, matcher.find());
    }
}

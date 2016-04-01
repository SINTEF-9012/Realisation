package no.sintef.bvr.planner.ui;

import java.io.ByteArrayOutputStream;
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
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;
import static no.sintef.bvr.planner.ui.Parameter.*;
import static org.junit.Assert.*;
import org.junit.Test;



class TestableController extends Controller {

    private final Operators operators;

    public TestableController(ByteArrayOutputStream output, FakeFileSystem fileSystem, Operators operators) {
        super(output, fileSystem);
        this.operators = operators;
    }

    @Override 
    protected IOperatorsReader operatorsReader(Settings settings) {
        return new FakeOperatorsReader(operators);
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
    private final FakeFileSystem fakeFileSystem;
    private final ByteArrayOutputStream fakeConsole;
    private final TestableController controller;

    public TestController() {
        fakeFileSystem = FakeFileSystem.withDefaultFileSet(GOAL_TEXT, ORIGIN_TEXT, "whatever");
        problem = prepareProblem();
        fakeConsole = new ByteArrayOutputStream();
        controller = new TestableController(fakeConsole, fakeFileSystem, problem.getOperators());
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
        fakeFileSystem.defineFile(originLocation, ORIGIN_TEXT);

        executeWith(ORIGIN.shortName(), originLocation);

        verifyOutputContains(ORIGIN_SUCCESSFULLY_LOADED, originLocation);
    }

    @Test
    public void shouldReportLoadingTheGoal() {
        final String goalLocation = "goal.state";
        fakeFileSystem.defineFile(goalLocation, GOAL_TEXT);

        executeWith(GOAL.shortName(), goalLocation);

        verifyOutputContains(GOAL_SUCCESSFULLY_LOADED, goalLocation);
    }

    @Test
    public void shouldReportLoadingOperators() {
        final String operatorLocation = "my-operators.txt";
        fakeFileSystem.defineFile(operatorLocation, "whatever");

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
        Matcher matcher = pattern.matcher(fakeConsole.toString());
        String error = String.format("Could not match pattern '%s' in text '%s'", patternText, fakeConsole.toString());
        assertTrue(error, matcher.find());
    }
}

package no.sintef.bvr.planner.ui;

import no.sintef.bvr.planner.ui.Controller;
import no.sintef.bvr.planner.repository.Repository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.sintef.bvr.planner.repository.FakeFactory;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.PlanningProblemBuilder;
import static no.sintef.bvr.planner.ui.Display.*;
import static no.sintef.bvr.planner.Status.*;
import static no.sintef.bvr.planner.ui.Parameter.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestBvrPlanner {

    private final FakeFactory factory;
    private final Controller planner;
    private final PlanningProblem problem; 
    
    public TestBvrPlanner() {
        this.factory = new FakeFactory();
        problem = prepareProblem();
        factory.define(ORIGIN.defaultValue(), problem.getOrigin());
        factory.define(GOAL.defaultValue(), problem.getGoal());
        factory.defineOperators(OPERATORS.defaultValue(), problem.getOperators());
        Repository repository = new Repository(factory);
        planner = new Controller(repository, factory.getDisplay());
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
        factory.define(originLocation, problem.getOrigin());
        
        executeWith(ORIGIN.shortName(), originLocation);

        verifyOutputContains(ORIGIN_SUCCESSFULLY_LOADED, originLocation);
    }

    @Test
    public void shouldReportLoadingTheGoal() {
        final String goalLocation = "goal.state";
        factory.define(goalLocation, problem.getGoal());
        
        executeWith(GOAL.shortName(), goalLocation);

        verifyOutputContains(GOAL_SUCCESSFULLY_LOADED, goalLocation);
    }

    @Test
    public void shouldReportLoadingOperators() {
        final String operatorLocation = "my-operators.txt";
        factory.defineOperators(operatorLocation, problem.getOperators());

        executeWith(OPERATORS.shortName(), operatorLocation);

        verifyOutputContains(OPERATORS_SUCCESSFULLY_LOADED, operatorLocation);
    }

    @Test
    public void shouldReportAboutFilesThatDoNotExist() {
        planner.execute(ORIGIN.shortName(), "fake.file");

        verifyOutputContains(UNABLE_TO_LOAD_FILE, "fake.file");
    }

    @Test
    public void shouldReportUnknownParameters() {
        final String unknownParameter = "--unknown-parameter";

        planner.execute(unknownParameter, "blablablablah!");

        verifyOutputContains(UNKNOWN_ARGUMENT, unknownParameter);
    }

    @Test
    public void shouldReportMissingParameters() {
        planner.execute(GOAL.shortName());

        verifyOutputContains(MISSING_ARGUMENT, GOAL.shortName());
    }

    private void executeWith(String... commandLine) {
        planner.execute(commandLine);
    }

    private void verifyOutputContains(String format, Object... values) {
        String patternText = String.format(format, values);
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(factory.getDisplayedOutput());
        String error = String.format("Could not match pattern '%s' in text '%s'", patternText, factory.getDisplayedOutput());
        assertTrue(error, matcher.find());
    }
}

package no.sintef.bvr.planner.ui;

import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.Repository;
import no.sintef.bvr.planner.repository.ReaderException;

public class Controller {

    private final Repository repository;
    private final Display display;

    public Controller(Repository repository, Display display) {
        this.repository = repository;
        this.display = display;
    }

    void execute(String... commandLine) {
        try {
            display.opening();
            Arguments arguments = parse(commandLine);
            PlanningProblem problem = new PlanningProblem(
                    loadOperators(arguments), 
                    loadOrigin(arguments), 
                    loadGoal(arguments));
            Plan plan = problem.solve();
            storePlan(plan, arguments);
            display.closing();

        } catch (UnknownArgumentException error) {
            display.reportUnknownArgument(error);

        } catch (InvalidArgumentException error) {
            display.reportInvalidArgument(error);

        } catch (ReaderException error) {
            display.reportReaderException(error);
        }
    }

    private Arguments parse(String[] commandLine) throws InvalidArgumentException, UnknownArgumentException {
        final Arguments arguments = Arguments.extractFrom(commandLine);
        repository.configureFor(arguments);
        return arguments;
    }

    private void storePlan(Plan plan, final Arguments arguments) {
        repository.store(plan);
        display.reportPlanStored(arguments);
    }

    private Operators loadOperators(final Arguments arguments) throws ReaderException {
        Operators operators = repository.getOperators();
        display.reportOperatorsLoaded(arguments);
        return operators;
    }

    private State loadGoal(final Arguments arguments) throws ReaderException {
        State goal = repository.getGoal();
        display.reportGoalLoaded(arguments);
        return goal;
    }

    private State loadOrigin(final Arguments arguments) throws ReaderException {
        State origin = repository.getOrigin();
        display.reportOriginLoaded(arguments);
        return origin;
    }

    public static void main(String[] arguments) {
        Repository repository = new Repository(null); // TODO to be updated
        Controller controller = new Controller(repository, new Display(System.out));
        controller.execute(arguments);
    }

}

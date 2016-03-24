package no.sintef.bvr.planner.ui;

import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.Repository;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;

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
            Arguments arguments = Arguments.extractFrom(commandLine);
            PlanningProblem problem
                    = new PlanningProblem(
                            loadOperators(arguments.getOperatorsLocation()),
                            loadOrigin(arguments.getOriginLocation()),
                            loadGoal(arguments.getGoalLocation()));
            Plan plan = problem.solve();
            storePlan(plan, arguments.getPlanLocation());
            display.closing();

        } catch (UnknownArgumentException error) {
            display.reportUnknownArgument(error);

        } catch (InvalidArgumentException error) {
            display.reportInvalidArgument(error);

        } catch (ReaderException error) {
            display.reportReaderException(error);
        
        } catch (WriterException error) {
            display.reportWriterException(error);
        }
    }

    private void storePlan(Plan plan, String location) throws WriterException {
        repository.store(plan, location);
        display.reportPlanStored(location);
    }

    private Operators loadOperators(String location) throws ReaderException {
        Operators operators = repository.getOperators(location);
        display.reportOperatorsLoaded(location);
        return operators;
    }

    private State loadGoal(String location) throws ReaderException {
        State goal = repository.getGoal(location);
        display.reportGoalLoaded(location);
        return goal;
    }

    private State loadOrigin(String location) throws ReaderException {
        State origin = repository.getOrigin(location);
        display.reportOriginLoaded(location);
        return origin;
    }

    public static void main(String[] arguments) {
        Repository repository = new Repository(null); // TODO to be updated
        Controller controller = new Controller(repository, new Display(System.out));
        controller.execute(arguments);
    }

}

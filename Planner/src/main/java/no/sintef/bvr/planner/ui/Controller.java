package no.sintef.bvr.planner.ui;

import no.sintef.bvr.planner.Settings;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.FileFactory;
import no.sintef.bvr.planner.repository.PlanWriter;
import no.sintef.bvr.planner.repository.PropertiesStateReader;
import no.sintef.bvr.planner.repository.Repository;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;

public class Controller {
    
    public static final String VERSION = Controller.class.getPackage().getImplementationVersion();

    private final Repository repository;
    private final Display display;

    public Controller(Repository repository, Display display) {
        this.repository = repository;
        this.display = display;
    }

    void execute(String... commandLine) {
        try {
            display.opening();
            Settings settings = parse(commandLine);
            PlanningProblem problem
                    = new PlanningProblem(
                            loadOperators(settings.getOperatorsLocation()),
                            loadOrigin(settings.getOriginLocation()),
                            loadGoal(settings.getGoalLocation()));
            Plan plan = problem.solve();
            storePlan(plan, settings.getPlanLocation());
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

    private Settings parse(String[] commandLine) throws UnknownArgumentException, InvalidArgumentException {
        CommandLineParser parser = new CommandLineParser();
        return parser.extractSettingsFrom(commandLine); 
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
        Repository repository = new Repository(new FileFactory(), new PropertiesStateReader(), null, new PlanWriter()); // TODO to be updated
        Controller controller = new Controller(repository, new Display(System.out));
        controller.execute(arguments);
    }

}

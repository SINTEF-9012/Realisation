package no.sintef.bvr.planner.ui;

import java.io.OutputStream;
import no.sintef.autorealspl.converter.main.BVREcoreVarModelToOperatorConverter;
import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.bvr.planner.Settings;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.FileSystem;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;
import no.sintef.bvr.planner.repository.PlanWriter;
import no.sintef.bvr.planner.repository.PropertiesStateReader;
import no.sintef.bvr.planner.repository.Repository;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;
import no.sintef.bvr.planner.repository.ecore.EcoreOperatorReader;

/**
 * Synchronize the resolution of the problem with the display
 */
public class Controller {

    protected final FileSystem fileSystem;
    private final Display display;
    private Repository repository;

    public Controller() {
        this(System.out, new FileSystem());
    }

    public Controller(OutputStream output, FileSystem fileSystem) {
        this.display = new Display(output);
        this.fileSystem = fileSystem;
    }

    void execute(String... commandLine) {
        try {
            display.opening();
            repository = configureRepositoryWith(settingsFrom(commandLine));
            PlanningProblem problem
                    = new PlanningProblem(operators(), origin(), goal());
            Plan solution = problem.solve();
            store(solution);
            display.closing();

        } catch (ReaderException error) {
            display.reportReaderException(error);

        } catch (WriterException error) {
            display.reportWriterException(error);

        } catch (UnknownArgumentException ex) {
            display.reportUnknownArgument(ex);

        } catch (InvalidArgumentException ex) {
            display.reportInvalidArgument(ex);
        }
    }

    private Settings settingsFrom(String[] commandLine) throws UnknownArgumentException, InvalidArgumentException {
        Settings settings = new CommandLineParser().extractSettingsFrom(commandLine);
        display.reportSettings(settings);
        return settings;
    }

    private Repository configureRepositoryWith(Settings settings) {
        return new Repository(
                new PropertiesStateReader(settings.getOriginLocation(), fileSystem),
                new PropertiesStateReader(settings.getGoalLocation(), fileSystem),
                operatorsReader(settings),
                new PlanWriter(settings.getPlanLocation(), fileSystem));
    }

    protected IOperatorsReader operatorsReader(Settings settings) {
        IConverter ecore_converter = new BVREcoreVarModelToOperatorConverter();
        return new EcoreOperatorReader(ecore_converter, settings.getOperatorsLocation());
    }

    private void store(Plan plan) throws WriterException {
        repository.store(plan);
        display.reportPlanStored();
    }

    private Operators operators() throws ReaderException {
        Operators operators = repository.getOperators();
        display.reportOperatorsLoaded();
        return operators;
    }

    private State goal() throws ReaderException {
        State goal = repository.getGoal();
        display.reportGoalLoaded();
        return goal;
    }

    private State origin() throws ReaderException {
        State origin = repository.getOrigin();
        display.reportOriginLoaded();
        return origin;
    }

    /**
     * Entry point of the CLI
     *
     * @param commandLine the list of arguments provided by the user
     */
    public static void main(String[] commandLine) {
        new Controller().execute(commandLine);
    }

}

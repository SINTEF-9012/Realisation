package no.sintef.bvr.planner.ui;

import no.sintef.bvr.planner.Settings;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.PlanningProblem;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.PlanWriter;
import no.sintef.bvr.planner.repository.PropertiesStateReader;
import no.sintef.bvr.planner.repository.Repository;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;

/**
 * Synchronize the resolution of the problem with the display
 */
public class Controller {

    private Display display;
    private Repository repository;


    void execute(String... commandLine) {
        try {
            display = configureDisplay();
            repository = configureRepositoryWith(settingsFrom(commandLine));
            PlanningProblem problem = new PlanningProblem(operators(), origin(), goal());
            storeSolution(problem.solve());
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

    protected Display configureDisplay() {
        display = new Display(System.out);
        display.opening();
        return display;
    }

    private Settings settingsFrom(String[] commandLine) throws UnknownArgumentException, InvalidArgumentException {
        Settings settings = new CommandLineParser().extractSettingsFrom(commandLine);
        display.reportSettings(settings);
        return settings;
    }

    protected Repository configureRepositoryWith(Settings settings) {
        return new Repository(
                new PropertiesStateReader(settings.getOriginLocation()),
                new PropertiesStateReader(settings.getGoalLocation()),
                null,
                new PlanWriter(settings.getPlanLocation()));
    }

    private void storeSolution(Plan plan) throws WriterException {
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

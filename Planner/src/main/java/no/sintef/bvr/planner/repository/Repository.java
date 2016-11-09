package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.repository.interfaces.IOperatorGenenerator;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;

/**
 * Facade that exposes the needed data objects using getters and setters
 */
public class Repository {

    private final StateReader origin;
    private final StateReader goal;
    private final IOperatorsReader reader;
    private final PlanWriter plan;

    public Repository(StateReader origin, StateReader goal, IOperatorsReader reader, PlanWriter plan) {
        this.origin = origin;
        this.goal = goal;
        this.reader = reader;
        this.plan = plan;
    }

    public State getOrigin() throws ReaderException {
        return origin.read();
    }

    public State getGoal() throws ReaderException {
        return goal.read();
    }

    public Operators getOperators() throws ReaderException {
        return reader.read();
    }

    public void store(Plan plan) throws WriterException {
        this.plan.write(plan);
    }
}

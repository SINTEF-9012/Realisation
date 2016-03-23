/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.ui.Display;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.Plan;
import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.ui.Arguments;

/**
 *
 * @author franckc
 */
public class Repository {

    private final Factory factory;
    private Arguments arguments;

    public Repository(Factory factory) {
        this.factory = factory;
    }

    public State getOrigin() throws ReaderException {
        final String location = arguments.getOriginLocation(); 
        final StateReader origin = factory.getStateReaderFor(location);
        return origin.read();
    }
    
    public State getGoal() throws ReaderException {
        final String location = arguments.getGoalLocation();
        final StateReader goal = factory.getStateReaderFor(location);
        return goal.read();
    }
    
    public Operators getOperators() throws ReaderException {
        final OperatorsReader operators = factory.getOperatorsReader();
        return operators.read();
    }

    public void configureFor(Arguments arguments) {
        this.arguments = arguments;
    }

    public void store(Plan plan) {
        final String planLocation = arguments.getPlanLocation();
        final PlanWriter writer = factory.getPlanWriter(planLocation);
        writer.write(plan);
    }


}

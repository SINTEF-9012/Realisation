/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

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

    public Repository(Factory factory) {
        this.factory = factory;
    }
  
    public State getOrigin(String location) throws ReaderException {
        final StateReader origin = factory.getStateReaderFor(location);
        return origin.read();
    }
    
    public State getGoal(String location) throws ReaderException {
        final StateReader goal = factory.getStateReaderFor(location);
        return goal.read();
    }
    
    public Operators getOperators(String location) throws ReaderException {
        final OperatorsReader operators = factory.getOperatorsReader();
        return operators.read();
    }

    public void store(Plan plan, String location) {
        final PlanWriter writer = factory.getPlanWriter(location);
        writer.write(plan);
    }


}

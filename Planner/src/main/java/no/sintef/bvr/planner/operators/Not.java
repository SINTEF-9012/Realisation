/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.operators.interfaces.IExpression;

/**
 *
 * @author franckc
 */
public class Not implements IExpression {

    private final IExpression operand;

    public Not(IExpression operand) {
        this.operand = operand;
    }

    @Override
    public boolean evaluateOn(State state) {
        return !operand.evaluateOn(state);
    }

    @Override
    public State applyTo(State currentState) {
        throw new RuntimeException("Cannot apply Not!");
    }

    @Override
    public String toString() {
        return "(not " + operand.toString() + ')';
    }
    
    
    
    
    
}

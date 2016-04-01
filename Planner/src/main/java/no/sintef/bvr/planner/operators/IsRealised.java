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
public class IsRealised implements IExpression {
    
    private final String featureName;

    public IsRealised(String featureName) {
        this.featureName = featureName;
    }

    @Override
    public boolean evaluateOn(State state) {
        return state.isRealised(featureName); 
    }

    @Override
    public State applyTo(State currentState) {
        throw new RuntimeException("Cannot apply isRealised!");
    }

    @Override
    public String toString() {
        return "IsRealised(" + featureName + ')';
    }

    
}

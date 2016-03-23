/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;
import no.sintef.bvr.planner.Status;

/**
 *
 * @author franckc
 */
public class IsNegative implements Expression {
    
    private final String feature;

    public IsNegative(String feature) {
        this.feature = feature;
    }

    @Override
    public boolean evaluateOn(State state) {
        return state.isNegative(feature);
    }

    @Override
    public State applyTo(State state) {
        return state.copyAndSet(feature, Status.NEGATIVE);
    }

    @Override
    public String toString() {
        return "IsNegative("+ feature + ')';
    }
    
    
    
}

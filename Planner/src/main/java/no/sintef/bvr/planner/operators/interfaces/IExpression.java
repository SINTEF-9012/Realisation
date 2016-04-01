/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators.interfaces;

import no.sintef.bvr.planner.State;

/**
 *
 * @author franckc
 */
public interface IExpression {

    public boolean evaluateOn(State state);

    public State applyTo(State state);
    
}

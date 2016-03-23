/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.operators;

import no.sintef.bvr.planner.State;

/**
 *
 * @author franckc
 */
public class Operator {

    private final String name;
    private final Expression preCondition;
    private final Expression postCondition;
    
    public Operator(String name, Expression preCondition, Expression postCondition) {
        this.name = name;
        this.preCondition = preCondition;
        this.postCondition = postCondition;
    }

    public String getName() {
        return name;
    }
    
    public boolean appliesTo(State currentState) {
        return preCondition.evaluateOn(currentState); 
    }

    public State applyTo(State currentState) {
        return postCondition.applyTo(currentState);
    }

    @Override
    public String toString() {
        return name + " pre:" + preCondition + " post:" + postCondition;
    }
    
    
       
}

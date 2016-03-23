/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import no.sintef.bvr.planner.operators.IsPositive;
import no.sintef.bvr.planner.operators.IsRealised;
import no.sintef.bvr.planner.operators.Not;
import no.sintef.bvr.planner.operators.Operator;

/**
 *
 * @author franckc
 */
public class OperatorsBuilder {
    
    private Operators operators;

    public OperatorsBuilder() {
        operators = new Operators();
    }
    
    public void addPositivelyRealise(String featureName) {
        operators.add(
            new Operator(
                "+" + featureName, 
                new Not(new IsRealised(featureName)), 
                new IsPositive(featureName))
        );
    }
    
    public Operators getResult() {
        return operators;
    }
    
}

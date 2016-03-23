/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franckc
 */
public class PlanFactory {

    public Plan with(String...operatorNames) {
        final List<Invoke> invocations = new ArrayList<>(operatorNames.length);
        for (String eachOperatorName: operatorNames) {
            invocations.add(new Invoke(eachOperatorName));
        }
        return new Plan(invocations);
    }
    
    public Plan empty() {
        return with();
    }
    
}

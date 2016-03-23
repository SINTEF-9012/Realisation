/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.ui;


public class InvalidArgumentException extends Exception {
    
    private final String parameter;
    
    public InvalidArgumentException(String parameterName) {
        this.parameter = parameterName;
    }

    public String getParameter() {
        return parameter;
    }
    
    
}

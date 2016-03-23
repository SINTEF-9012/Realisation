/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.ui;

/**
 *
 * @author franckc
 */
public class UnknownArgumentException extends Exception {

    private final String unknownArgument;
    
    public UnknownArgumentException(String unknownArgument) {
        this.unknownArgument = unknownArgument;
    }

    public String getUnknownArgument() {
        return unknownArgument;
    }
    
    
}

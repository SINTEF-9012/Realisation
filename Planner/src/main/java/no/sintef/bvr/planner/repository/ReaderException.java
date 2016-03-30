/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

/**
 *
 * @author franckc
 */
public class ReaderException extends Exception {
    
    public ReaderException(String location, Throwable cause) {
        super(location, cause);
    }    

    public ReaderException(String error) {
        super(error);
    }    
    
}

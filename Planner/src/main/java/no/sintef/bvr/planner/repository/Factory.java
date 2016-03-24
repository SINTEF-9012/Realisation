/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author franckc
 */
public interface Factory {
        
    InputStream asInput(String location) throws IOException;
    
    OutputStream asOutput(String location) throws IOException;
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.InputStream;
import no.sintef.bvr.planner.Operators;

/**
 *
 * @author franckc
 */
public interface OperatorsReader {
    
    Operators read() throws ReaderException;
     
}

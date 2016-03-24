/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.OutputStream;
import no.sintef.bvr.planner.Plan;

/**
 *
 * @author franckc
 */
public interface PlanWriter {

    void write(Plan plan);
    
    void write(Plan plan, OutputStream destination) throws WriterException ;
    
}

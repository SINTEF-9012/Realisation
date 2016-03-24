/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.IOException;
import java.io.OutputStream;
import no.sintef.bvr.planner.Plan;

/**
 *
 * @author franckc
 */
public class FakePlanWriter implements PlanWriter {

    @Override
    public void write(Plan plan) {
        // Nothing to do
    }

    @Override
    public void write(Plan plan, OutputStream destination) throws WriterException {
        try {
            destination.write(plan.toString().getBytes());
            
        } catch (IOException error) {
            throw new WriterException("Unable to write plan", error);
        }
    }

    
    
    
}

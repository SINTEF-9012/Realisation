/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import no.sintef.bvr.planner.ui.Display;

/**
 *
 * @author franckc
 */
public interface Factory {
    
    public StateReader getStateReaderFor(String location);
    
    public OperatorsReader getOperatorsReader();
    
    public PlanWriter getPlanWriter(String location);

    public Display getDisplay();
    
}

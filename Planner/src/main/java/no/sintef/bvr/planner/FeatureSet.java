/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

/**
 *
 * @author franckc
 */
public interface FeatureSet {

    public int count();

    public Iterable<String> names();

    public int indexOf(String eachFeature);
    
    public String at(int index);
    
}

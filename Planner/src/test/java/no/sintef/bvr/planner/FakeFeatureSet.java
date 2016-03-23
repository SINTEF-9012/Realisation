/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franckc
 */
public class FakeFeatureSet implements FeatureSet {
    
    public static final String DEFAULT_FEATURE_NAME = "f%1$d";
   
    private final String pattern;
    private final Map<String, Integer> indexes;
    
    
    public FakeFeatureSet(int count) {
        this(count, DEFAULT_FEATURE_NAME);
    }
    
    public FakeFeatureSet(int count, String namePattern) {
        pattern = namePattern;
        indexes = new HashMap<>();
        for (int index=0 ; index<count ;index++) {
            indexes.put(at(index), index);
        }
    }

    @Override
    public int count() {
        return indexes.size();
    }

    @Override
    public Iterable<String> names() {
        return indexes.keySet();
    }

    @Override
    public int indexOf(String featureName) {
        return indexes.get(featureName);
    }
    
    @Override
    public final String at(int index) {
        return  String.format(pattern, index+1);
    }
    
    
    
}

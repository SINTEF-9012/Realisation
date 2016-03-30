/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate feature names based on the number of feature and a name pattern
 */
public class FakeFeatureSet extends FeatureSet {

    public static final String DEFAULT_FEATURE_NAME = "f%1$d";

    public FakeFeatureSet(int count) {
        this(count, DEFAULT_FEATURE_NAME);
    }

    public FakeFeatureSet(int count, String namePattern) {
        super(createNames(count, namePattern));
    }

    private static Iterable<String> createNames(int count, String pattern) {
        final List<String> names = new ArrayList<>(count);
        for (int index = 0; index < count; index++) {
            final String featureName = String.format(pattern, index+1);
            names.add(featureName);
        }
        return names;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent the set of features defined in the product line
 */
public class FeatureSet {

    private final Map<String, Integer> indexes;

    public FeatureSet(Iterable<String> featureNames) {
        indexes = new HashMap<>();
        int featureIndex = 0;
        for (String eachFeatureName : featureNames) {
            indexes.put(eachFeatureName, featureIndex);
            featureIndex++;
        }
    }

    public int count() {
        return indexes.size();
    }

    public Iterable<String> names() {
        return indexes.keySet();
    }

    public int indexOf(String eachFeature) {
        return indexes.get(eachFeature);
    }

    public String at(int index) {
        for (String anyFeature : names()) {
            if (indexOf(anyFeature) == index) {
                return anyFeature;
            }
        }
        return null;
    }

    public String toString() {
        final StringBuilder buffer = new StringBuilder();

        for (Map.Entry<String, Integer> eachEntry : indexes.entrySet()) {
            final String text = String.format("%1$s -> %2$d", eachEntry.getKey(), eachEntry.getValue());
            buffer.append(text);
        }

        return buffer.toString();
    }
}

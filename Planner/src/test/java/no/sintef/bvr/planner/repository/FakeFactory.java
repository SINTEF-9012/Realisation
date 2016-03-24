/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.ByteArrayInputStream;
import no.sintef.bvr.planner.ui.Display;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class FakeFactory implements Factory {

    public static final String OPERATOR_MARKER = "operators";

    private final Map<String, InputStream> inputs;
    private final Map<String, OutputStream> outputs;

    public FakeFactory() {
        inputs = new HashMap<>();
        outputs = new HashMap<>();
    }

    @Override
    public InputStream asInput(String location) throws IOException {
        if (!inputs.containsKey(location)) {
            throw new FileNotFoundException(location);
        }
        return inputs.get(location);
    }

    @Override
    public OutputStream asOutput(String location) {
        if (!outputs.containsKey(location)) {
            outputs.put(location, new ByteArrayOutputStream());
        }
        return outputs.get(location);
    }

    public void define(String location, String contents) {
        inputs.put(location, new ByteArrayInputStream(contents.getBytes()));
    }

}

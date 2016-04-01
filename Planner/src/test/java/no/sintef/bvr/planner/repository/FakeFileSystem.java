/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import no.sintef.bvr.planner.Settings;

/**
 * In memory file system, as a map for string to input/output streams
 */
public class FakeFileSystem extends FileSystem {

    public static final String OPERATOR_MARKER = "operators";

    public static FakeFileSystem withDefaultFileSet(String originText, String goalText, String operatorText) {
        FakeFileSystem fileSystem = new FakeFileSystem();
        fileSystem.defineFile(Settings.DEFAULT_GOAL_LOCATION, goalText);
        fileSystem.defineFile(Settings.DEFAULT_ORIGIN_LOCATION, originText);
        fileSystem.defineFile(Settings.DEFAULT_OPERATORS_LOCATION, operatorText);
        return fileSystem;
    }
    
    private final Map<String, InputStream> inputs;
    private final Map<String, OutputStream> outputs;

    public FakeFileSystem() {
        inputs = new HashMap<>();
        outputs = new HashMap<>();
    }

    public void setGoalFile(String location, String content) {
        defineFile(location, content);
    }

    public void setOriginFile(String location, String content) {
        defineFile(location, content);
    }

    public void setOperatorsFile(String location, String content) {
        defineFile(location, content);
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

    public void defineFile(String location, String contents) {
        inputs.put(location, new ByteArrayInputStream(contents.getBytes()));
    }

}

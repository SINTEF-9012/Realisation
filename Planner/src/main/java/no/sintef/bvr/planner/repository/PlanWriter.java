/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import no.sintef.bvr.planner.Plan;

/**
 * Write a plan at a given location
 */
public class PlanWriter {

    private final String fileLocation;
    private final FileSystem fileSystem;
    
    public PlanWriter(String location) {
        this(location, new FileSystem());
    }
    
    public PlanWriter(String location, FileSystem fileSystem) {
        this.fileLocation = location;
        this.fileSystem = fileSystem;
    }

    public void write(Plan plan) throws WriterException {
        try {
            OutputStream output = fileSystem.asOutput(fileLocation);
            output.write(plan.toString().getBytes());

        } catch (IOException error) {
            throw new WriterException("Unable to write plan", error);
        }
    }

}

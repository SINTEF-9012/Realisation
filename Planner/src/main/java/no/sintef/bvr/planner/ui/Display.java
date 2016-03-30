/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.ui;

import java.io.OutputStream;
import java.io.PrintStream;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;

/**
 * Command line interface
 */
public class Display {

    public static final String COPYRIGHT = "Copyright (C) 2016 SINTEF ICT";
    public static final String VERSION = "BVR Planner v%1$s";
    public static final String ORIGIN_SUCCESSFULLY_LOADED = "Initial state loaded from '%1$s'.";
    public static final String GOAL_SUCCESSFULLY_LOADED = "Goal state loaded from %1$s";
    public static final String OPERATORS_SUCCESSFULLY_LOADED = "Operators loaded from '%1$s'";
    public static final String PLAN_STORED = "Plan stored in '%1$s'";
    public static final String UNABLE_TO_LOAD_FILE = "Error: Unable to load state. %1$s";
    public static final String UNKNOWN_ARGUMENT = "Error: Unknown argument '%1$s'";
    public static final String MISSING_ARGUMENT = "Error: Missing argument '%1$s' value";
    public static final String UNABLE_TO_WRITE_PLAN = "Error: Unable to write plan. %1$s";
    public static final String PARAMETER_DETAILS = " - [%1$s|%2$s] <path-to-file>, %3$s\n";
    public static final String COMMAND_LINE_USAGE = "USAGE: 'java -jar planner.jar <parameters>' \n" + 
                                                    "where <parameters> may include:\n";
    public static final String CLOSING_MESSAGE = "That's all folks!";

    
    private final PrintStream output;

    public Display(OutputStream output) {
        this.output = new PrintStream(output, true);
    }

    void reportReaderException(ReaderException error) {
        format(UNABLE_TO_LOAD_FILE, error.getMessage());
    }

    void reportInvalidArgument(InvalidArgumentException error) {
        format(MISSING_ARGUMENT, error.getParameter());
        showUsage();
    }

    void reportUnknownArgument(UnknownArgumentException error) {
        format(UNKNOWN_ARGUMENT, error.getUnknownArgument());
        showUsage();
    }

    void reportOriginLoaded(String location) {
        format(ORIGIN_SUCCESSFULLY_LOADED, location);
    }

    void reportGoalLoaded(String location) {
        format(GOAL_SUCCESSFULLY_LOADED, location);
    }

    void reportOperatorsLoaded(String location) {
        format(OPERATORS_SUCCESSFULLY_LOADED, location);
    }

    void reportWriterException(WriterException error) {
        format(UNABLE_TO_WRITE_PLAN, error.getMessage());
    }

    void reportPlanStored(String location) {
        format(PLAN_STORED, location);
    }

    private void format(String pattern, Object... values) {
        final String message = String.format(pattern, values);
        output.println(message);
    }

    void opening() {
        format(VERSION, "v0.1");
        format(COPYRIGHT);
    }

    void closing() {
        format(CLOSING_MESSAGE);
    }

    void showUsage() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(COMMAND_LINE_USAGE);
        for (Parameter eachParameter : Parameter.values()) {
            String description
                    = String.format(PARAMETER_DETAILS,
                            eachParameter.shortName(),
                            eachParameter.longName(),
                            eachParameter.description());
            buffer.append(description);
        }
        output.println(buffer.toString());
    }

}

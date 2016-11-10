/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.ui;

import java.io.OutputStream;
import java.io.PrintStream;
import no.sintef.bvr.planner.Settings;
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
    public static final String UNABLE_TO_LOAD_FILE = "Error: Unable to load file '%1$s'";
    public static final String UNKNOWN_ARGUMENT = "Error: Unknown argument '%1$s'";
    public static final String MISSING_ARGUMENT = "Error: Missing argument '%1$s' value";
    public static final String UNABLE_TO_WRITE_PLAN = "Error: Unable to write plan. %1$s";
    public static final String PARAMETER_DETAILS = " * [%1$s|%2$s] <path-to-file>, %3$s";
    public static final String COMMAND_LINE_USAGE
            = "\n"
            + "USAGE: 'java -jar planner.jar <parameters>' \n"
            + "where <parameters> may include:";
    public static final String CLOSING_MESSAGE = "That's all folks!";
    public static final String FEATURE_MODEL_LOADED = "BVR feature model is loaded from '%1$s'";
    public static final String OPERATORS_SAVED_SUCCESSFULLY = "Generated operators are save to '%1$s'";

    private final PrintStream output;
    private Settings settings;

    public Display(OutputStream output) {
        this.settings = null;
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

    void reportOriginLoaded() {
        format(ORIGIN_SUCCESSFULLY_LOADED, settings.getOriginLocation());
    }

    void reportGoalLoaded() {
        format(GOAL_SUCCESSFULLY_LOADED, settings.getGoalLocation());
    }

    void reportOperatorsLoaded() {
        format(OPERATORS_SUCCESSFULLY_LOADED, settings.getOperatorsLocation());
    }

    void reportWriterException(WriterException error) {
        format(UNABLE_TO_WRITE_PLAN, error.getMessage());
    }

    void reportPlanStored() {
        format(PLAN_STORED, settings.getPlanLocation());
    }
    
    void reportBVRModelLoaded() {
    	format(FEATURE_MODEL_LOADED, settings.getFeatureModelLocation());
    }
    
    void reportGeneratedOperatorsSaved() {
    	format(OPERATORS_SAVED_SUCCESSFULLY, settings.getOperatorsLocation());
    }
    
    void reportGeneratedOperatorsToModelSaved() {
    	format(OPERATORS_SAVED_SUCCESSFULLY, settings.getModelOperatorsLocation());
    }

    void opening() {
        final String currentVersion = Display.class.getPackage().getImplementationVersion();
        format(VERSION, currentVersion);
        format(COPYRIGHT);
        output.println("\n");
    }

    void closing() {
        format(CLOSING_MESSAGE);
    }

    private void format(String pattern, Object... values) {
        final String message = String.format(pattern, values);
        output.println(message);
    }

    void showUsage() {
        format(COMMAND_LINE_USAGE);
        for (Parameter eachParameter : Parameter.values()) {
            format(PARAMETER_DETAILS,
                    eachParameter.shortName(),
                    eachParameter.longName(),
                    eachParameter.description());
        }
    }

    void reportSettings(Settings settings) {
        this.settings = settings;
    }

}

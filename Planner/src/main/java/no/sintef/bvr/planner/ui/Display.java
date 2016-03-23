/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner.ui;

import java.io.OutputStream;
import java.io.PrintStream;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.ui.Arguments;
import no.sintef.bvr.planner.ui.InvalidArgumentException;
import no.sintef.bvr.planner.ui.UnknownArgumentException;

/**
 *
 */
public class Display {

    public static final String COPYRIGHT = "Copyright (C) SINTEF ICT 2016";
    public static final String VERSION = "BVR Planner v%1$s";
    public static final String ORIGIN_SUCCESSFULLY_LOADED = "Initial state loaded from '%1$s'.";
    public static final String GOAL_SUCCESSFULLY_LOADED = "Goal state loaded from %1$s";
    public static final String OPERATORS_SUCCESSFULLY_LOADED = "Operators loaded from '%1$s'";
    public static final String PLAN_STORED = "Plan stored in '%1$s'";
    public static final String UNABLE_TO_LOAD_FILE = "Error: Unable to load file '%1$s'.";
    public static final String UNKNOWN_ARGUMENT = "Error: Unknown argument '%1$s'";
    public static final String MISSING_ARGUMENT = "Error: Missing argument '%1$s' value";

    private final PrintStream output;

    public Display(OutputStream output) {
        this.output = new PrintStream(output, true);
    }

    public void reportReaderException(ReaderException error) {
        if (error instanceof ReaderException) {
            format(UNABLE_TO_LOAD_FILE, error.getLocation());
        }
    }

    void reportInvalidArgument(InvalidArgumentException error) {
        format(MISSING_ARGUMENT, error.getParameter());
    }

    void reportUnknownArgument(UnknownArgumentException error) {
        format(UNKNOWN_ARGUMENT, error.getUnknownArgument());
    }

    void reportOriginLoaded(Arguments arguments) {
        format(ORIGIN_SUCCESSFULLY_LOADED, arguments.getOriginLocation());
    }

    void reportGoalLoaded(Arguments arguments) {
        format(GOAL_SUCCESSFULLY_LOADED, arguments.getGoalLocation());
    }

    void reportOperatorsLoaded(Arguments arguments) {
        format(OPERATORS_SUCCESSFULLY_LOADED, arguments.getOperatorsLocation());
    }

    private void format(String pattern, Object... values) {
        final String message = String.format(pattern, values);
        output.println(message);
    }

    void reportPlanStored(Arguments arguments) {
        format(PLAN_STORED, arguments.getPlanLocation());
    }

    void opening() {
        format(VERSION, "v0.1");
        format(COPYRIGHT);
    }

    void closing() {
        format("That's all folks!");
    }

}

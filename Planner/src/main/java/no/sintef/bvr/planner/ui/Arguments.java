package no.sintef.bvr.planner.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Arguments {

    
    public static Arguments extractFrom(String... commandLine) throws UnknownArgumentException, InvalidArgumentException {
        final Arguments arguments = Arguments.defaultValues();
        final List<String> tokens = new ArrayList<>(Arrays.asList(commandLine));
        while (!tokens.isEmpty()) {
           Parameter parameter = matchNext(tokens);
           extract(tokens, parameter, arguments);
        }
        return arguments;
    }

    private static void extract(final List<String> tokens, Parameter parameter, final Arguments arguments) throws InvalidArgumentException {
        final String parameterName = tokens.remove(0);        
        if (tokens.isEmpty()) throw new InvalidArgumentException(parameterName);
        arguments.define(parameter, tokens.remove(0));
    }
    
    private static Parameter matchNext(List<String> tokens) throws UnknownArgumentException {
        final String key = tokens.get(0);
        for (Parameter eachParameter: Parameter.values()) {
            if (eachParameter.match(key)) {
                return eachParameter;
            }
        }
        throw new UnknownArgumentException(key);
    }
    
    public static Arguments defaultValues() {
        Arguments arguments = new Arguments();
        for(Parameter eachParameter: Parameter.values()) {
            arguments.define(eachParameter, eachParameter.defaultValue());
        }
        return arguments;
    }

    private final Map<Parameter, String> values;

    
    Arguments() {
        this.values = new HashMap<>();
    }
    
    Arguments(String initialStateLocation, String goal) {
        this();
        define(Parameter.ORIGIN, initialStateLocation);
    }

    protected final void define(Parameter parameter, String value) {
        values.put(parameter, value);
    }

    protected String valueOf(Parameter key) {
        return values.get(key);
    }

    public String getOriginLocation() {
        return values.get(Parameter.ORIGIN);
    }

    public String getGoalLocation() {
        return values.get(Parameter.GOAL);
    }
    
    public String getOperatorsLocation() {
        return values.get(Parameter.OPERATORS);
    }

    public String getPlanLocation() {
        return values.get(Parameter.PLAN);
    }

}

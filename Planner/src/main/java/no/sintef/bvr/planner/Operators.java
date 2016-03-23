package no.sintef.bvr.planner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import no.sintef.bvr.planner.operators.Operator;

/**
 *
 * @author franckc
 */
public class Operators implements Iterable<Operator> {

    private final Map<String, Operator> operators;

    public Operators() {
        operators = new HashMap<>();
    }

    void add(Operator operator) {
        operators.put(operator.getName(), operator);
    }

    public Operator get(String name) {
        return operators.get(name);
    }

    @Override
    public Iterator<Operator> iterator() {
        return operators.values().iterator();
    }

}

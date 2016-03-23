package no.sintef.bvr.planner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import no.sintef.bvr.planner.operators.Operator;

/**
 *
 * @author franckc
 */
public class Plan {

    private final List<Invoke> invocations;

    public Plan() {
        this(new LinkedList<Invoke>());
    }

    public Plan(Invoke... actions) {
        this(Arrays.asList(actions));
    }

    public Plan(List<Invoke> actions) {
        this.invocations = actions;
    }
    
    public Plan extendWith(Operator operator) {
        List<Invoke> invocations = new ArrayList<>(this.invocations);
        invocations.add(new Invoke(operator.getName()));
        return new Plan(invocations);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.invocations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plan other = (Plan) obj;
        return Objects.equals(this.invocations, other.invocations);
    }
    
    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append("(");
        for (Invoke eachInvocation : invocations) {
            buffer.append(eachInvocation.getOperatorName());
            buffer.append(" ");
        }
        buffer.append(")");
        return buffer.toString();
    }

}

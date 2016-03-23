package no.sintef.bvr.planner;

import java.util.BitSet;
import java.util.Objects;
import static no.sintef.bvr.planner.Status.*;

public class State {

    private static final String INCONSISTENT_INDEXES_AND_STATUSES = "Inconsistent indexes and statuses (%1$d statuses but %2$d features)";

    private final FeatureSet features;
    private final BitSet status;

    State(FeatureSet features, Status... statuses) {
        if (statuses.length != features.count()) {
            final String error = String.format(INCONSISTENT_INDEXES_AND_STATUSES, statuses.length, features.count());
            throw new IllegalArgumentException(error);
        }
        this.features = features;
        this.status = new BitSet(2 * features.count());
        for (String eachFeature : features.names()) {
            setStatus(eachFeature, statuses[features.indexOf(eachFeature)]);
        }
    }

    State(State model) {
        this.features = model.features;
        this.status = (BitSet) model.status.clone();
    }

    Status statusOf(String feature) {
        if (isPending(feature)) {
            return PENDING;
        } else if (isPositive(feature)) {
            return POSITIVE;
        } else if (isNegative(feature)) {
            return NEGATIVE;
        } else {
            throw new RuntimeException("Invalid state POSTIVE and not realised!");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.status);
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
        final State other = (State) obj;
        return Objects.equals(this.status, other.status);
    }

    final void setStatus(String feature, Status status) {
        switch (status) {
            case PENDING:
                setPending(feature);
                break;
            case POSITIVE:
                setPositive(feature);
                break;
            case NEGATIVE:
                setNegative(feature);
                break;
            default:
                throw new RuntimeException("Unknown status '" + status.name() + "'");
        }
    }

    private void setPending(String feature) {
        status.set(isRealisedBit(feature), false);
        status.set(isPositiveBit(feature), false);
    }

    private int isRealisedBit(String feature) {
        return indexOf(feature);
    }

    private int isPositiveBit(String feature) {
        return features.count() + indexOf(feature);
    }

    private void setPositive(String feature) {
        status.set(isRealisedBit(feature), true);
        status.set(isPositiveBit(feature), true);
    }

    private void setNegative(String feature) {
        status.set(isRealisedBit(feature), true);
        status.set(isPositiveBit(feature), false);
    }

    private int indexOf(String feature) {
        return features.indexOf(feature);
    }

    public boolean isRealised(String feature) {
        return status.get(isRealisedBit(feature));
    }

    public boolean isPending(String feature) {
        return !isRealised(feature);
    }

    public boolean isPositive(String feature) {
        return isRealised(feature) 
               && status.get(isPositiveBit(feature));
    }

    public boolean isNegative(String feature) {
        return isRealised(feature)
                && !status.get(isPositiveBit(feature));
    }

    public State copyAndSet(String featureName, Status status) {
        State copy = new State(this);
        copy.setStatus(featureName, status);
        return copy;
    }

    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append("(");
        for (String eachFeature : features.names()) {
            buffer.append(eachFeature);
            buffer.append(":");
            buffer.append(statusOf(eachFeature));
            buffer.append(" ");
        }
        buffer.append(")");
        return buffer.toString();
    }

}

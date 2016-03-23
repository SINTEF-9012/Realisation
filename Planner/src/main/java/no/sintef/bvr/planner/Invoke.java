/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.planner;

import java.util.Objects;


public class Invoke {

    private final String operatorName;

    public Invoke(String operatorName) {
        this.operatorName = operatorName;
    }

    String getOperatorName() {
        return operatorName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.operatorName);
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
        final Invoke other = (Invoke) obj;
        return Objects.equals(this.operatorName, other.operatorName);
    }
       
    
    
}

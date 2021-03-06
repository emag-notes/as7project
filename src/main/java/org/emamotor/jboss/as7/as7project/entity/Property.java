package org.emamotor.jboss.as7.as7project.entity;

import java.io.Serializable;

public class Property implements Serializable {

    private String key;
    
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Property [key=" + key + ", value=" + value + "]";
    }
    
}

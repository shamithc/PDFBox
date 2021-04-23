package com.example.demo.controller;

public class LookupValue {
    int valueId;
    String displayName;

    public LookupValue(int valueId, String displayName) {
        this.valueId = valueId;
        this.displayName = displayName;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

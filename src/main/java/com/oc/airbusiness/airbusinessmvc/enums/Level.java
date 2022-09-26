package com.oc.airbusiness.airbusinessmvc.enums;

public enum Level {
    MINOR("Minor"),
    MEDIUM("Medium"),
    SEVERE("Severe");
    private final String displayValue;


    Level(String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }
}

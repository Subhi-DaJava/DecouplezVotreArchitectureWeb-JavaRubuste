package com.oc.airbusiness.airbusinessmvc.enums;

public enum SubSystem {
    ENGINE("Engine"),
    FUSELAGE("Fuselage"),
    LEFT_WING("Left Wing"),
    LEFT_HORIZONTAL_STABILIZER("Left Horizontal Stabilizer"),
    RIGHT_WING("Right Wing"),
    RIGHT_HORIZONTAL_STABILIZER("Right Horizontal Stabilizer"),
    RUDDER("Rudder");

    private final String displayValue;

    SubSystem(String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }
}

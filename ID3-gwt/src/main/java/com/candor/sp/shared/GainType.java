package com.candor.sp.shared;

public enum GainType {
    INFORMATION_GAIN("Information Gain"),
    GAIN_RATIO("Gain Ratio");

    private String value;

    GainType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GainType valueOf(int value) {
        for (GainType entityType : values()) {
            if (entityType.getValue().equals(value)) {
                return entityType;
            }
        }

        throw new IllegalArgumentException("Invalid value [" + value + "].");
    }
}

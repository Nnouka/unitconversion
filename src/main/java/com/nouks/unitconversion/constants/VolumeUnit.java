package com.nouks.unitconversion.constants;

public enum  VolumeUnit {
    TABLESPOON ("tablespoon", "tablespoons", 0.0147868),
    CUBIC_INCH ("cubic-inch", "cubic-inches", 0.0163871),
    CUP ("cup", "cups", 0.236588),
    CUBIC_FOOT ("cubic-foot", "cubic-feet", 28.3168),
    GALLON ("gallon", "gallons", 3.78541),
    LITER("liter", "liters", 1.0);
    private String unit;
    private String plural;
    private Double conversionFactor;

    VolumeUnit(String unit, String plural, Double conversionFactor) {
        this.unit = unit;
        this.plural = plural;
        this.conversionFactor = conversionFactor;
    }

    public String getUnit() {
        return unit;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public String getPlural() {
        return plural;
    }
}

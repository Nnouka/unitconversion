package com.nouks.unitconversion.constants;

public enum  VolumeUnit {
    TABLESPOON ("tablespoon", "tablespoons", 0.014786, 0.0),
    CUBIC_INCH ("cubic-inch", "cubic-inches", 0.0163871, 0.0),
    CUP ("cup", "cups", 0.236588, 0.0),
    CUBIC_FOOT ("cubic-foot", "cubic-feet", 28.3168, 0.0),
    GALLON ("gallon", "gallons", 3.78541, 0.0),
    LITTER ("litter", "litters", 1.0, 0.0);
    private String unit;
    private String plural;
    private Double conversionFactor;
    private Double offset;

    VolumeUnit(String unit, String plural, Double conversionFactor, Double offset) {
        this.unit = unit;
        this.plural = plural;
        this.conversionFactor = conversionFactor;
        this.offset = offset;
    }

    public String getUnit() {
        return unit;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public Double getOffset() {
        return offset;
    }

    public String getPlural() {
        return plural;
    }
}

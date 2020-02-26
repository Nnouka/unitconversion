package com.nouks.unitconversion.constants;

public enum TemperatureUnit {
    CELSIUS ("celsius", "celsius", 1.0, 273.15),
    FAHRENHEIT ("fahrenheit", "fahrenheits", 5.0/9, 2298.35/9),
    RANKINE ("rankine", "rankine", 5.0/9, 0.0),
    KELVIN ("kelvin", "kelvins", 1.0, 0.0);
    private String unit;
    private String plural;
    private Double conversionFactor;
    private Double offset;

    TemperatureUnit(String unit, String plural, Double conversionFactor, Double offset) {
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

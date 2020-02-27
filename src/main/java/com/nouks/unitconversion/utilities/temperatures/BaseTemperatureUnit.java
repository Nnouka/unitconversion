package com.nouks.unitconversion.utilities.temperatures;

import com.nouks.unitconversion.constants.TemperatureUnit;

public class BaseTemperatureUnit {
    private Double value;
    private TemperatureUnit temperatureUnit;

    public BaseTemperatureUnit(Double value, TemperatureUnit temperatureUnit) {
        System.out.println("-----<Wiring>----");
        System.out.println(temperatureUnit.getUnit());
        this.value = value;
        this.temperatureUnit = temperatureUnit;
        System.out.println("--------<OK>----------");
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(TemperatureUnit temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    // convert to kelvin
    public Double toKelvin() {
        return temperatureUnit.getConversionFactor() * getValue() + temperatureUnit.getOffset();
    }
    // convert to celsius
    public Double toCelsius() {
        return convertTo(TemperatureUnit.CELSIUS);
    }
    // convert to Fahrenheit
    public Double toFahrenheit() {
        return convertTo(TemperatureUnit.FAHRENHEIT);
    }
    // convert to Rankine
    public Double toRankine() {
        return convertTo(TemperatureUnit.RANKINE);
    }

    private Double convertTo(TemperatureUnit temperatureUnit) {
        return (toKelvin() - temperatureUnit.getOffset()) * (1.0/temperatureUnit.getConversionFactor()) ;
    }
}

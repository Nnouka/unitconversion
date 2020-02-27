package com.nouks.unitconversion.utilities.temperatures;

import com.nouks.unitconversion.constants.TemperatureUnit;

public class Fahrenheit extends BaseTemperatureUnit {
    public Fahrenheit(Double value) {
        super(value, TemperatureUnit.FAHRENHEIT);
    }
}

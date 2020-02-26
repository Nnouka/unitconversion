package com.nouks.unitconversion.utilities.temperatures;

import com.nouks.unitconversion.constants.TemperatureUnit;

public class Fahrenheit extends BaseScale {
    public Fahrenheit(Double value) {
        super(value, TemperatureUnit.FAHRENHEIT);
    }
}

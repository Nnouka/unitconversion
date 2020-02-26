package com.nouks.unitconversion.utilities.temperatures;

import com.nouks.unitconversion.constants.TemperatureUnit;

public class Celsius extends BaseScale {
    public Celsius(Double value) {
        super(value, TemperatureUnit.CELSIUS);
    }
}

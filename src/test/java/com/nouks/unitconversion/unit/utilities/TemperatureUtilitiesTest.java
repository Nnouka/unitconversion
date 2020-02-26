package com.nouks.unitconversion.unit.utilities;

import com.nouks.unitconversion.utilities.maths.MathsHelper;
import com.nouks.unitconversion.utilities.temperatures.Celsius;
import com.nouks.unitconversion.utilities.temperatures.Fahrenheit;
import com.nouks.unitconversion.utilities.temperatures.Kelvin;
import com.nouks.unitconversion.utilities.temperatures.Rankine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureUtilitiesTest {
    @Test
    public void givenCelsiusToKelvin_ReturnCorrectValue() {
        Celsius celsius = new Celsius(20.0);
        assertEquals(293.15, celsius.toKelvin(), 0.0);
        Kelvin kelvin1 = new Kelvin(293.15);
        assertEquals(20.0, MathsHelper.round(kelvin1.toCelsius(), 2), 0.0);
    }

    @Test
    public void givenCelsiusToFahrenheit_ReturnCorrectValue() {
        Celsius celsius = new Celsius(20.0);
        assertEquals(68.00, MathsHelper.round(celsius.toFahrenheit(), 2), 0.0);
        Fahrenheit fahrenheit = new Fahrenheit(68.0);
        assertEquals(20.00, MathsHelper.round(fahrenheit.toCelsius(), 2), 0.0);
    }

    @Test
    public void givenCelsiusToRankine_ReturnCorrectValue() {
        Celsius celsius = new Celsius(30.0);
        assertEquals(545.67, MathsHelper.round(celsius.toRankine(), 2), 0.0);
        Rankine rankine = new Rankine(545.67);
        assertEquals(30.00, MathsHelper.round(rankine.toCelsius(), 2), 0.0);
    }

    @Test
    public void givenRankineToFahrenheit_ReturnCorrectValue() {
        Rankine rankine = new Rankine(10.0);
        assertEquals(-449.67, MathsHelper.round(rankine.toFahrenheit(), 2), 0.0);
        Fahrenheit fahrenheit = new Fahrenheit(-449.67);
        assertEquals(10.00, MathsHelper.round(fahrenheit.toRankine(), 2), 0.0);
    }
}

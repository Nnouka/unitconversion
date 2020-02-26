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
        Double kelvin = celsius.toKelvin();
        assertEquals(293.15, kelvin, 0.0);
        Kelvin kelvin1 = new Kelvin(293.15);
        Double celsiusVal = kelvin1.toCelsius();
        assertEquals(20.0, MathsHelper.round(celsiusVal, 2), 0.0);
    }

    @Test
    public void givenCelsiusToFahrenheit_ReturnCorrectValue() {
        Celsius celsius = new Celsius(20.0);
        Double fahrenheitVal = celsius.toFahrenheit();
        assertEquals(68.00, MathsHelper.round(fahrenheitVal, 2), 0.0);
        Fahrenheit fahrenheit = new Fahrenheit(68.0);
        Double celsiusVal = fahrenheit.toCelsius();
        assertEquals(20.00, MathsHelper.round(celsiusVal, 2), 0.0);
    }

    @Test
    public void givenCelsiusToRankine_ReturnCorrectValue() {
        Celsius celsius = new Celsius(30.0);
        Double rankineVal = celsius.toRankine();
        assertEquals(545.67, MathsHelper.round(rankineVal, 2), 0.0);
        Rankine rankine = new Rankine(545.67);
        Double celsiusVal = rankine.toCelsius();
        assertEquals(30.00, MathsHelper.round(celsiusVal, 2), 0.0);
    }

    @Test
    public void givenRankineToFahrenheit_ReturnCorrectValue() {
        Rankine rankine = new Rankine(10.0);
        Double fahrenheitVal = rankine.toFahrenheit();
        assertEquals(-449.67, MathsHelper.round(fahrenheitVal, 2), 0.0);
        Fahrenheit fahrenheit = new Fahrenheit(-449.67);
        Double rankineVal = fahrenheit.toRankine();
        assertEquals(10.00, MathsHelper.round(rankineVal, 2), 0.0);
    }
}

package com.nouks.unitconversion.unit.services;

import com.nouks.unitconversion.services.AutowiredQuantity;
import com.nouks.unitconversion.services.ConversionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ConversionServiceTest {
    ConversionService conversionService;
    @Before
    public void setup() {
        conversionService = new ConversionService(new AutowiredQuantity());
    }

    @Test
    public void givenInput_returnCorrectOutput() {
        // case one correct
        assertEquals("correct",
                conversionService.respond("Fahrenheit", 84.2, "Rankine", 543.94));
        // case two incorrect
        assertEquals("incorrect",
                conversionService.respond("Kelvin", 317.33, "Fahrenheit", 111.554));
        // case three correct
        assertEquals("correct",
                conversionService.respond("cups", 25.6, "liters", 6.1));
        // case four invalid
        assertEquals("invalid",
                conversionService.respond("gallons", 73.12, "Kelvin", 19.4));
        // case five incorrect
        assertEquals("incorrect",
                conversionService.respond("Fahrenheit", 6.5, "Rankine", "dog"));
        // case six invalid
        assertEquals("invalid",
                conversionService.respond("dog", 136.1, "Celsius", 45.32));
    }
}

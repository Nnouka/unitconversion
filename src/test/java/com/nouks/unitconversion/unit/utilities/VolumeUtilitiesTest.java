package com.nouks.unitconversion.unit.utilities;

import com.nouks.unitconversion.utilities.maths.MathsHelper;
import com.nouks.unitconversion.utilities.volumes.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class VolumeUtilitiesTest {
    @Test
    public void givenLittersToGallon_returnCorrectValue() {
        Liter liter = new Liter(10.0);
        assertEquals(2.64, MathsHelper.round(liter.toGallon(), 2), 0.0);
        Gallon gallon = new Gallon(2.64);
        Double literVal = gallon.toLiter();
        assertEquals(10.0, MathsHelper.round(literVal, 1), 0.0);
    }

    @Test
    public void givenGallonToCup_returnCorrectValue() {
        Gallon gallon = new Gallon(12.0);
        assertEquals(192.0, MathsHelper.round(gallon.toCup(), 2), 0.0);
        Cup cup = new Cup(192.0);
        Double gallonVal = cup.toGallon();
        assertEquals(12.0, MathsHelper.round(gallonVal, 2), 0.0);
    }

    @Test
    public void givenGallonToTablespoon_returnCorrectValue() {
        Gallon gallon = new Gallon(15.0);
        assertEquals(3840.0, MathsHelper.round(gallon.toTablespoon(), 1), 0.0);
        Tablespoon tablespoon = new Tablespoon(3840.0);
        Double gallonVal = tablespoon.toGallon();
        assertEquals(15.0, MathsHelper.round(gallonVal, 1), 0.0);
    }

    @Test
    public void givenGallonToCubicFoot_returnCorrectValue() {
        Gallon gallon = new Gallon(20.0);
        assertEquals(2.7, MathsHelper.round(gallon.toCubicFoot(), 1), 0.0);
        CubicFoot cubicFoot = new CubicFoot(2.7);
        assertEquals(20.2, MathsHelper.round(cubicFoot.toGallon(), 1), 0.0);
    }
    @Test
    public void givenGallonToCubicInch_returnCorrectValue() {
        Gallon gallon = new Gallon(20.0);
        assertEquals(4620.0, MathsHelper.round(gallon.toCubicInch(), 1), 0.0);
        CubicInch cubicInch = new CubicInch(4620.0);
        assertEquals(20.0, MathsHelper.round(cubicInch.toGallon(), 1), 0.0);
    }
}

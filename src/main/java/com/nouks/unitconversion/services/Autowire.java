package com.nouks.unitconversion.services;

import com.nouks.unitconversion.utilities.temperatures.*;
import com.nouks.unitconversion.utilities.volumes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Autowire {
    public BaseScale setTemperatureScale(String unit, Double value) {
        switch (unit.toUpperCase().trim()) {
            case "CELSIUS":
                return new Celsius(value);
            case "KELVIN":
                return new Kelvin(value);
            case "RANKINE":
                return new Rankine(value);
            case "FAHRENHEIT":
                return new Fahrenheit(value);
            default:
                return null;
        }
    }

    public BaseUnit setVolumeUnit(String unit, Double value) {
        switch (unit.replace("-", "").replace("_", "").toUpperCase().trim()) {
            case "TABLESPOON":
                return new Tablespoon(value);
            case "CUBICINCH":
                return new CubicInch(value);
            case "CUP":
                return new Cup(value);
            case "CUBICFOOT":
                return new CubicFoot(value);
            case "GALLON":
                return new Gallon(value);
            case "LITER":
                return new Liter(value);
            default:
                return null;
        }
    }

    public Double getTemperatureConversion(BaseScale baseScale, String targetUnit) {
        if (baseScale != null) {
            switch (targetUnit.toUpperCase().trim()) {
                case "CELSIUS":
                    return baseScale.toCelsius();
                case "KELVIN":
                    return baseScale.toKelvin();
                case "RANKINE":
                    return baseScale.toRankine();
                case "FAHRENHEIT":
                    return baseScale.toFahrenheit();
                default:
                    return null;
            }
        }
        return null;
    }

    public Double getVolumeConversion(BaseUnit baseVol, String targetUnit) {
        if (baseVol != null) {
            switch (targetUnit.replace("-", "").replace("_", "").toUpperCase().trim()) {
                case "TABLESPOON":
                    return baseVol.toTablespoon();
                case "CUBICINCH":
                    return baseVol.toCubicInch();
                case "CUP":
                    return baseVol.toCup();
                case "CUBICFOOT":
                    return baseVol.toCubicFoot();
                case "GALLON":
                    return baseVol.toGallon();
                case "LITER":
                    return baseVol.toLiter();
                default:
                    return null;
            }
        }
        return null;
    }

    public Double convert(String baseUnit, Double value, String targetUnit) {
        BaseScale baseScale;
        BaseUnit baseVol;
        if (isTemperature(baseUnit)) {
            baseScale = setTemperatureScale(baseUnit, value);
            return getTemperatureConversion(baseScale, targetUnit);
        } else if (isVolume(baseUnit)) {
            baseVol = setVolumeUnit(baseUnit, value);
            return getVolumeConversion(baseVol, targetUnit);
        } else { // null is when units are invalid
            return null;
        }
    }

    public boolean isTemperature(String unit) {
        List<String> temperatures = new ArrayList<>(Arrays.asList("CELSIUS", "KELVIN", "RANKINE"));
        for (String tem : temperatures) {
            if (tem.equalsIgnoreCase(unit.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean isVolume(String unit) {
        List<String> volumes = new ArrayList<>(Arrays.asList(
                "TABLESPOON", "CUBICINCH", "CUP", "CUBICFOOT", "GALLON", "LITER"
        ));
        for (String vol: volumes) {
            if (vol.equalsIgnoreCase(unit.trim())) {
                return true;
            }
        }
        return false;
    }
}

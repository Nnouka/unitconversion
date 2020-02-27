package com.nouks.unitconversion.services;

import com.nouks.unitconversion.utilities.temperatures.*;
import com.nouks.unitconversion.utilities.volumes.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class AutowiredQuantity {
    public AutowiredQuantity() {
    }
    public BaseTemperatureUnit setTemperatureScale(String unit, Double value) {
        switch (unit.toUpperCase().trim()) {
            case "CELSIUS":
                return new Celsius(value);
            case "KELVIN":
            case "KELVINS":
                return new Kelvin(value);
            case "RANKINE":
            case "RANKINES":
                return new Rankine(value);
            case "FAHRENHEIT":
            case "FAHRENHEITS":
                return new Fahrenheit(value);
            default:
                return null;
        }
    }

    public BaseVolumeUnit setVolumeUnit(String unit, Double value) {
        switch (unit.replace("-", "").replace("_", "").toUpperCase().trim()) {
            case "TABLESPOON":
            case "TABLESPOONS":
                return new Tablespoon(value);
            case "CUBICINCH":
            case "CUBICINCHES":
                return new CubicInch(value);
            case "CUP":
            case "CUPS":
                return new Cup(value);
            case "CUBICFOOT":
            case "CUBICFEET":
                return new CubicFoot(value);
            case "GALLON":
            case "GALLONS":
                return new Gallon(value);
            case "LITER":
            case "LITERS":
                return new Liter(value);
            default:
                return null;
        }
    }

    public Double getTemperatureConversion(BaseTemperatureUnit baseTemperatureUnit, String targetUnit) {
        if (baseTemperatureUnit != null) {
            switch (targetUnit.toUpperCase().trim()) {
                case "CELSIUS":
                    return baseTemperatureUnit.toCelsius();
                case "KELVIN":
                case "KELVINS":
                    return baseTemperatureUnit.toKelvin();
                case "RANKINE":
                case "RANKINES":
                    return baseTemperatureUnit.toRankine();
                case "FAHRENHEIT":
                case "FAHRENHEITS":
                    return baseTemperatureUnit.toFahrenheit();
                default:
                    return null;
            }
        }
        return null;
    }

    public Double getVolumeConversion(BaseVolumeUnit baseVol, String targetUnit) {
        if (baseVol != null) {
            switch (targetUnit.replace("-", "").replace("_", "").toUpperCase().trim()) {
                case "TABLESPOON":
                case "TABLESPOONS":
                    return baseVol.toTablespoon();
                case "CUBICINCH":
                case "CUBICINCHES":
                    return baseVol.toCubicInch();
                case "CUP":
                case "CUPS":
                    return baseVol.toCup();
                case "CUBICFOOT":
                case "CUBICFEET":
                    return baseVol.toCubicFoot();
                case "GALLON":
                case "GALLONS":
                    return baseVol.toGallon();
                case "LITER":
                case "LITERS":
                    return baseVol.toLiter();
                default:
                    return null;
            }
        }
        return null;
    }

    public Double convert(String baseUnit, Double value, String targetUnit) {
        BaseTemperatureUnit baseTemperatureUnit;
        BaseVolumeUnit baseVol;
        if (isTemperature(baseUnit)) {
            baseTemperatureUnit = setTemperatureScale(baseUnit, value);
            return getTemperatureConversion(baseTemperatureUnit, targetUnit);
        } else if (isVolume(baseUnit)) {
            baseVol = setVolumeUnit(baseUnit, value);
            return getVolumeConversion(baseVol, targetUnit);
        } else { // null is when units are invalid
            return null;
        }
    }

    public boolean isTemperature(String unit) {
        List<String> temperatures = new ArrayList<>(Arrays.asList("CELSIUS", "KELVIN", "RANKINE", "FAHRENHEIT",
                "KELVINS", "RANKINES", "FAHRENHEITS"));
        for (String tem : temperatures) {
            if (tem.equalsIgnoreCase(unit.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean isVolume(String unit) {
        List<String> volumes = new ArrayList<>(Arrays.asList(
                "TABLESPOON", "CUBICINCH", "CUP", "CUBICFOOT", "GALLON", "LITER",
                "TABLESPOONS", "CUBICINCHES", "CUPS", "CUBICFEET", "GALLONS", "LITERS"
        ));
        for (String vol: volumes) {
            if (vol.equalsIgnoreCase(unit.trim())) {
                return true;
            }
        }
        return false;
    }
}

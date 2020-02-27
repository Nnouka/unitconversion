package com.nouks.unitconversion.utilities.volumes;

import com.nouks.unitconversion.constants.VolumeUnit;

public class BaseVolumeUnit {
    private Double value;
    private VolumeUnit volumeUnit;

    public BaseVolumeUnit(Double value, VolumeUnit volumeUnit) {
        System.out.println("-----<Wiring>----");
        System.out.println(volumeUnit.getUnit());
        this.value = value;
        this.volumeUnit = volumeUnit;
        System.out.println("--------<OK>----------");
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public VolumeUnit getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(VolumeUnit volumeUnit) {
        this.volumeUnit = volumeUnit;
    }
    // convert to liters
    public Double toLiter() {
        return volumeUnit.getConversionFactor() * getValue();
    }
    // convert to other units
    public Double convertTo(VolumeUnit volumeUnit) {
       return toLiter() * (1.0/volumeUnit.getConversionFactor());
    }
    // convert to tablespoon
    public Double toTablespoon() {
        return convertTo(VolumeUnit.TABLESPOON);
    }
    // convert to cubicInch
    public Double toCubicInch() {
        return convertTo(VolumeUnit.CUBIC_INCH);
    }
    // convert to cup
    public Double toCup() {
        return convertTo(VolumeUnit.CUP);
    }
    // convert to cubicFoot
    public Double toCubicFoot() {
        return convertTo(VolumeUnit.CUBIC_FOOT);
    }
    // convert to gallon
    public Double toGallon() {
        return convertTo(VolumeUnit.GALLON);
    }
}

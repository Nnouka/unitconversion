package com.nouks.unitconversion.dtos;

public class UnitConversionDTO {
    private Double inputValue;
    private String inputUnit;
    private String targetUnit;
    private Object response;

    public UnitConversionDTO() {
    }

    public UnitConversionDTO(Double inputValue, String inputUnit, String targetUnit, Object response) {
        this.inputValue = inputValue;
        this.inputUnit = inputUnit;
        this.targetUnit = targetUnit;
        this.response = response;
    }

    public Double getInputValue() {
        return inputValue;
    }

    public void setInputValue(Double inputValue) {
        this.inputValue = inputValue;
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(String inputUnit) {
        this.inputUnit = inputUnit;
    }

    public String getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}

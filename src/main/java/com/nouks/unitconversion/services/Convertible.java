package com.nouks.unitconversion.services;

public interface Convertible {
    public String respond(String baseUnit, Double value, String targetUnit, Object studentResponse);
}

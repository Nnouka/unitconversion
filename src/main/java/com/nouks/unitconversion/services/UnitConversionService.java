package com.nouks.unitconversion.services;

import com.nouks.unitconversion.utilities.maths.MathsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitConversionService implements Convertible {
    private AutowiredQuantity autowiredQuantity;

    @Autowired
    public UnitConversionService(AutowiredQuantity autowiredQuantity) {
        this.autowiredQuantity = autowiredQuantity;
    }


    @Override
    public String respond(String baseUnit, Double value, String targetUnit, Object studentResponse) {
            return verify(
                    autowiredQuantity.convert(baseUnit, value, targetUnit), studentResponse
            );

    }

    private String verify(Double authoritative, Object response) {
        if (authoritative == null) return "invalid";
        if (response instanceof Double) {
            if (MathsHelper.round(authoritative, 1) == MathsHelper.round((Double) response, 1)) {
                return "correct";
            }
        }
        return "incorrect";
    }
}

package com.nouks.unitconversion.services;

import com.nouks.unitconversion.utilities.maths.MathsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionService implements Convertible {
    private AutowiredQuantity autowiredQuantity;

    @Autowired
    public ConversionService(AutowiredQuantity autowiredQuantity) {
        this.autowiredQuantity = autowiredQuantity;
    }


    @Override
    public String respond(String baseUnit, Double value, String targetUnit, Object studentResponse) {
        if (studentResponse instanceof Double) {
            return verify(
                    autowiredQuantity.convert(baseUnit, value, targetUnit), ((Double) studentResponse)
            );
        }
        return "incorrect";
    }

    private String verify(Double authoritative, Double response) {
        if (authoritative == null) return "invalid";
        if (MathsHelper.round(authoritative, 1) == MathsHelper.round(response, 1)) {
            return "correct";
        }
        return "incorrect";
    }
}

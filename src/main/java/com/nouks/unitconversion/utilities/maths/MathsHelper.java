package com.nouks.unitconversion.utilities.maths;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathsHelper {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException("Negative places does not make sense");
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}

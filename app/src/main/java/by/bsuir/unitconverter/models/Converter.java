package by.bsuir.unitconverter.models;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Converter {
    public static String convert(String value, Unit from, Unit to) {

        BigDecimal result = new BigDecimal(value).setScale(6, RoundingMode.HALF_UP);
        if (from.getId() != to.getId()) {
            BigDecimal multiplier = BigDecimal.valueOf(from.getConversionToBaseUnit()).multiply(BigDecimal.valueOf(to.getConversionFromBaseUnit()));
            BigDecimal bdResult = new BigDecimal(value).multiply(multiplier);
            result = bdResult.setScale(6, RoundingMode.HALF_UP);
        }
        return getStrippedDouble(result.doubleValue());
    }

    public static String getStrippedDouble(double d) {
        if (d == (long) d)
            return String.format(Locale.US, "%d", (long) d);
        else
            return String.format("%s", d);
    }
}

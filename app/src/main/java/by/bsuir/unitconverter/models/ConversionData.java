package by.bsuir.unitconverter.models;



import java.util.ArrayList;
import java.util.List;

import by.bsuir.unitconverter.R;

import static by.bsuir.unitconverter.models.Unit.*;


public class ConversionData {

    // ConversionFromBase - на какой аргумент нужно умножить переводимое число в Sq Metre, чтобы перевести его в желаемую единицу ( сколько в одной единице числа будет SqMetre)
    // ConversionToBase - сколко в одной единице SqlMetre будет числа
    // conversionFromBase - сколько SQ_Meters в этой величине
    //Sq_kilometer, metres ... - ID for radioButton

    public static List<Unit> getAreaConversions() {
        //Base Unit = area
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(SQ_KILOMETRES, R.string.sq_kilometre, 1000000.0, 0.000001));
        units.add(new Unit(SQ_METRES, R.string.sq_metre, 1.0, 1.0));
        units.add(new Unit(SQ_CENTIMETRES, R.string.sq_centimetre, 0.0001, 10000.0));
        units.add(new Unit(HECTARE, R.string.hectare, 10000.0, 0.0001));
        units.add(new Unit(SQ_MILE, R.string.sq_mile, 2589988.110336, 0.000000386102158542445847));
        units.add(new Unit(SQ_YARD, R.string.sq_yard, 0.83612736, 1.19599004630108026));
        units.add(new Unit(SQ_FOOT, R.string.sq_foot, 0.09290304, 10.7639104167097223));
        units.add(new Unit(SQ_INCH, R.string.sq_inch, 0.00064516, 1550.00310000620001));
        units.add(new Unit(ACRE, R.string.acre, 4046.8564224, 0.000247105381467165342));
        return units;
    }

    public static List<Unit> getStorageConversions() {
        //Base Unit = megabyte
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(BIT, R.string.bit, 0.00000011920928955078, 8388608.0));
        units.add(new Unit(BYTE, R.string.Byte, 0.00000095367431640625, 1048576.0));
        units.add(new Unit(KILOBIT, R.string.kilobit, 0.0001220703125, 8192.0));
        units.add(new Unit(KILOBYTE, R.string.kilobyte, 0.0009765625, 1024.0));
        units.add(new Unit(MEGABIT, R.string.megabit, 0.125, 8.0));
        units.add(new Unit(MEGABYTE, R.string.megabyte, 1.0, 1.0));
        units.add(new Unit(GIGABIT, R.string.gigabit, 128.0, 0.0078125));
        units.add(new Unit(GIGABYTE, R.string.gigabyte, 1024.0, 0.0009765625));
        units.add(new Unit(TERABIT, R.string.terabit, 131072.0, 0.00000762939453125));
        units.add(new Unit(TERABYTE, R.string.terabyte, 1048576.0, 0.00000095367431640625));
        return units;
    }

    public static List<Unit> getTimeConversions() {
        //Base unit - seconds
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(YEAR, R.string.year, 31536000.0, 0.0000000317097919837645865));
        units.add(new Unit(MONTH, R.string.month, 2628000.0, 0.0000003805175));
        units.add(new Unit(WEEK, R.string.week, 604800.0, 0.00000165343915343915344));
        units.add(new Unit(DAY, R.string.day, 86400.0, 0.0000115740740740740741));
        units.add(new Unit(HOUR, R.string.hour, 3600.0, 0.000277777777777777778));
        units.add(new Unit(MINUTE, R.string.minute, 60.0, 0.0166666666666666667));
        units.add(new Unit(SECOND, R.string.second, 1.0, 1.0));
        units.add(new Unit(MILLISECOND, R.string.millisecond, 0.001, 1000.0));
        units.add(new Unit(NANOSECOND, R.string.nanosecond, 0.000000001, 1000000000.0));
        return units;
    }
}

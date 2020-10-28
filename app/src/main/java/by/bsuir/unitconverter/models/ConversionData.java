package by.bsuir.unitconverter.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.bsuir.unitconverter.R;

import static by.bsuir.unitconverter.models.Unit.*;


public class ConversionData {

    // ConversionFromBase - на какой аргумент нужно умножить переводимое число в Sq Metre, чтобы перевести его в желаемую единицу ( сколько в одной единице числа будет SqMetre)
    // ConversionToBase - сколко в одной единице SqlMetre будет числа
    // conversionFromBase - сколько SQ_Meters в этой величине
    //Sq_kilometer, metres ... - ID for radioButton
    public static final String Area = "Area";
    public static final String Storage = "Digital Storage";
    public static final String Time = "Time";

    public static List<Unit> getAreaConversions() {
        //Base Unit = area
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(SQ_KILOMETRES, sq_kilometre, 1000000.0, 0.000001));
        units.add(new Unit(SQ_METRES, sq_metre, 1.0, 1.0));
        units.add(new Unit(SQ_CENTIMETRES, sq_centimetre, 0.0001, 10000.0));
        units.add(new Unit(HECTARE, hectare, 10000.0, 0.0001));
        units.add(new Unit(SQ_MILE,sq_mile, 2589988.110336, 0.000000386102158542445847));
        units.add(new Unit(SQ_YARD, sq_yard, 0.83612736, 1.19599004630108026));
        units.add(new Unit(SQ_FOOT, sq_foot, 0.09290304, 10.7639104167097223));
        units.add(new Unit(SQ_INCH,sq_inch, 0.00064516, 1550.00310000620001));
        units.add(new Unit(ACRE, acre, 4046.8564224, 0.000247105381467165342));
        return units;
    }

    public static List<Unit> getStorageConversions() {
        //Base Unit = megabyte
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(BIT, bit, 0.00000011920928955078, 8388608.0));
        units.add(new Unit(BYTE, Byte, 0.00000095367431640625, 1048576.0));
        units.add(new Unit(KILOBIT, kilobit, 0.0001220703125, 8192.0));
        units.add(new Unit(KILOBYTE, kilobyte, 0.0009765625, 1024.0));
        units.add(new Unit(MEGABIT, megabit, 0.125, 8.0));
        units.add(new Unit(MEGABYTE, megabyte, 1.0, 1.0));
        units.add(new Unit(GIGABIT, gigabit, 128.0, 0.0078125));
        units.add(new Unit(GIGABYTE, gigabyte, 1024.0, 0.0009765625));
        units.add(new Unit(TERABIT, terabit, 131072.0, 0.00000762939453125));
        units.add(new Unit(TERABYTE, terabyte, 1048576.0, 0.00000095367431640625));
        return units;
    }

    public static List<Unit> getTimeConversions() {
        //Base unit - seconds
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(YEAR, year, 31536000.0, 0.0000000317097919837645865));
        units.add(new Unit(MONTH, month, 2628000.0, 0.0000003805175));
        units.add(new Unit(WEEK, week, 604800.0, 0.00000165343915343915344));
        units.add(new Unit(DAY, day, 86400.0, 0.0000115740740740740741));
        units.add(new Unit(HOUR, hour, 3600.0, 0.000277777777777777778));
        units.add(new Unit(MINUTE, minute, 60.0, 0.0166666666666666667));
        units.add(new Unit(SECOND, second, 1.0, 1.0));
        units.add(new Unit(MILLISECOND, millisecond, 0.001, 1000.0));
        units.add(new Unit(NANOSECOND, nanosecond, 0.000000001, 1000000000.0));
        return units;
    }

    public static HashMap<String, Unit> getDefaultHashMap() {
        HashMap<String, Unit> map = new HashMap<>();
        map.put(Area, new Unit(SQ_KILOMETRES, sq_kilometre, 1000000.0, 0.000001));
        map.put(Storage, new Unit(BIT, bit, 0.00000011920928955078, 8388608.0));
        map.put(Time, new Unit(YEAR, year, 31536000.0, 0.0000000317097919837645865));
        return map;
    }

    public static HashMap<String, List<Unit>> getConversions() {
        HashMap<String, List<Unit>> conversions = new HashMap<>();
        conversions.put(Area, getAreaConversions());
        conversions.put(Storage, getStorageConversions());
        conversions.put(Time, getTimeConversions());
        return conversions;
    }

}

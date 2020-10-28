package by.bsuir.unitconverter.models;

public class Unit {
    // Area

    //ID for radioButton
    public static final int SQ_KILOMETRES = 0;
    public static final int SQ_METRES = 1;
    public static final int SQ_CENTIMETRES = 2;
    public static final int HECTARE = 3;
    public static final int SQ_MILE = 4;
    public static final int SQ_YARD = 5;
    public static final int SQ_FOOT = 6;
    public static final int SQ_INCH = 7;
    public static final int ACRE = 8;


    // Storage
    public static final int BIT = 100;
    public static final int BYTE = 101;
    public static final int KILOBIT = 102;
    public static final int KILOBYTE = 103;
    public static final int MEGABIT = 104;
    public static final int MEGABYTE = 105;
    public static final int GIGABIT = 106;
    public static final int GIGABYTE = 107;
    public static final int TERABIT = 108;
    public static final int TERABYTE = 109;

    // Time
    public static final int YEAR = 1000;
    public static final int MONTH = 1001;
    public static final int WEEK = 1002;
    public static final int DAY = 1003;
    public static final int HOUR = 1004;
    public static final int MINUTE = 1005;
    public static final int SECOND = 1006;
    public static final int MILLISECOND = 1007;
    public static final int NANOSECOND = 1008;

    // Area
    public final static String sq_kilometre = "Sq Kilometre";
    public final static String sq_metre = "Sq Metre";
    public final static String sq_centimetre = "Sq Centimetre";
    public final static String hectare = "Hectare";
    public final static String sq_mile = "Sq Mile";
    public final static String sq_yard = "Sq Yard";
    public final static String sq_foot = "Sq Foot";
    public final static String sq_inch = "Sq Inch";
    public final static String acre = "Acre";

    // Digital Storage
    public final static String bit = "Bit";
    public final static String Byte = "Byte";
    public final static String kilobit = "Kilobit";
    public final static String kilobyte = "Kilobyte";
    public final static String megabit = "Megabit";
    public final static String megabyte = "Megabyte";
    public final static String gigabit = "Gigabit";
    public final static String gigabyte = "Gigabyte";
    public final static String terabit = "Terabit";
    public final static String terabyte = "Terabyte";

    // Time
    public final static String year = "Year";
    public final static String month = "Month";
    public final static String week = "Week";
    public final static String day = "Day";
    public final static String hour = "Hour";
    public final static String minute = "Minute";
    public final static String second = "Second";
    public final static String millisecond = "Millisecond";
    public final static String nanosecond = "Nanosecond";





    private int id;
    private String label;
    private double conversionToBase;
    private double conversionFromBase;

    public Unit(int id, String label, double conversionToBase, double conversionFromBase) {
        this.id = id;
        this.label = label;
        this.conversionToBase = conversionToBase;
        this.conversionFromBase = conversionFromBase;
    }

    public int getId() {
        return id;
    }

    public double getConversionToBaseUnit() {
        return conversionToBase;
    }

    public double getConversionFromBaseUnit() {
        return conversionFromBase;
    }

    public String getLabel() {
        return label;
    }
}

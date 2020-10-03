package by.bsuir.unitconverter.models;



import java.util.HashMap;

import by.bsuir.unitconverter.R;

import static by.bsuir.unitconverter.models.Unit.BIT;
import static by.bsuir.unitconverter.models.Unit.SQ_KILOMETRES;
import static by.bsuir.unitconverter.models.Unit.YEAR;


public class FromToItemsDefaultValue {
    public static HashMap<Integer, Unit> getDefaultHashMap() {

        HashMap<Integer, Unit> map = new HashMap<>();
        map.put(R.string.area, new Unit(SQ_KILOMETRES, R.string.sq_kilometre, 1000000.0, 0.000001));
        map.put(R.string.storage, new Unit(BIT, R.string.bit, 0.00000011920928955078, 8388608.0));
        map.put(R.string.time, new Unit(YEAR, R.string.year, 31536000.0, 0.0000000317097919837645865));
        return map;
    }
}

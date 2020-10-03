package by.bsuir.unitconverter.view_model;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import by.bsuir.unitconverter.R;
import by.bsuir.unitconverter.models.Calculator;
import by.bsuir.unitconverter.models.ConversionData;
import by.bsuir.unitconverter.models.Converter;
import by.bsuir.unitconverter.models.FromToItemsDefaultValue;
import by.bsuir.unitconverter.models.Unit;

public class SharedViewModel extends ViewModel implements LifecycleObserver {

    private final MutableLiveData<String> buttonSelected = new MutableLiveData<>();
    private final MutableLiveData<String> fromValue = new MutableLiveData<>("0");
    private final MutableLiveData<String> toValue = new MutableLiveData<>();
    private final MutableLiveData<List<Unit>> selectedUnitList = new MutableLiveData<>(ConversionData.getAreaConversions());
    private final MutableLiveData<HashMap<Integer, Unit>> selectedFromUnits = new MutableLiveData<>(FromToItemsDefaultValue.getDefaultHashMap());
    private final MutableLiveData<HashMap<Integer, Unit>> selectedToUnits = new MutableLiveData<>(FromToItemsDefaultValue.getDefaultHashMap());
    private final MutableLiveData<Integer> toolbarTitleResourceID = new MutableLiveData<>(R.string.area);

    private int previousMenuItem = R.id.areaFragment;

    public void selectButton(String button_selected) {
        buttonSelected.setValue(Calculator.processExpr(button_selected));
        fromValue.setValue(Calculator.result.toString());
    }

    public void selectUnitListAndToolbarTitle(int categoryID) {
        if (previousMenuItem != categoryID) {
            previousMenuItem = categoryID;
            List<Unit> unit;
            switch (categoryID) {
                case R.id.storageFragment:
                    toolbarTitleResourceID.setValue(R.string.storage);
                    unit = ConversionData.getStorageConversions();
                    break;
                case R.id.timeFragment:
                    toolbarTitleResourceID.setValue(R.string.time);
                    unit = ConversionData.getTimeConversions();
                    break;
                default: // Area
                    toolbarTitleResourceID.setValue(R.string.area);
                    unit = ConversionData.getAreaConversions();
                    break;
            }
            selectedUnitList.setValue(unit);
        }
    }

    public void setToValue() {
        if (Objects.equals(fromValue.getValue(), "")) {
            toValue.setValue("0");
        } else {
            toValue.setValue(Converter.convert(fromValue.getValue(), getSelectedFromUnit(), getSelectedToUnit()));
        }
    }


    public void setSelectedFromUnit(Unit unit) {
        Objects.requireNonNull(selectedFromUnits.getValue()).put(toolbarTitleResourceID.getValue(), unit);
    }

    public void setSelectedToUnit(Unit unit) {
        Objects.requireNonNull(selectedToUnits.getValue()).put(toolbarTitleResourceID.getValue(), unit);
    }

    public LiveData<List<Unit>> getSelectedUnitList() {
        return selectedUnitList;
    }

    public LiveData<String> getToValue() {
        return toValue;
    }

    public LiveData<String> getButtonSelected() {
        return buttonSelected;
    }

    public LiveData<String> getFromValue() {
        return fromValue;
    }


    public Unit getSelectedFromUnit() {
        return Objects.requireNonNull(selectedFromUnits.getValue()).get(toolbarTitleResourceID.getValue());
    }

    public Unit getSelectedToUnit() {
        return Objects.requireNonNull(selectedToUnits.getValue()).get(toolbarTitleResourceID.getValue());
    }

    public LiveData<Integer> getToolbarTitleResourceID() {
        return toolbarTitleResourceID;
    }
}

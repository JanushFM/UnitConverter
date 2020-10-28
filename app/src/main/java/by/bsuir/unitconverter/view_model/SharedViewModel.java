package by.bsuir.unitconverter.view_model;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import by.bsuir.unitconverter.models.Calculator;
import by.bsuir.unitconverter.models.ConversionData;
import by.bsuir.unitconverter.models.Converter;
import by.bsuir.unitconverter.models.Unit;

public class SharedViewModel extends ViewModel implements LifecycleObserver {

    private final MutableLiveData<String> buttonSelected = new MutableLiveData<>();
    private final MutableLiveData<String> fromValue = new MutableLiveData<>("0");
    private final MutableLiveData<String> toValue = new MutableLiveData<>();
    private final MutableLiveData<List<Unit>> selectedUnitList = new MutableLiveData<>(ConversionData.getAreaConversions());
    private final MutableLiveData<HashMap<String, Unit>> selectedFromUnits = new MutableLiveData<>(ConversionData.getDefaultHashMap());
    private final MutableLiveData<HashMap<String, Unit>> selectedToUnits = new MutableLiveData<>(ConversionData.getDefaultHashMap());
    private final MutableLiveData<String> toolbarTitle = new MutableLiveData<>(ConversionData.Area);
    private final HashMap<String, List<Unit>> conversions = ConversionData.getConversions();
    private String previousCategoryName = ConversionData.Area;

    public void selectButton(String button_selected) {
        buttonSelected.setValue(Calculator.processExpr(button_selected));
        fromValue.setValue(Calculator.result.toString());
    }

    public void selectUnitListAndToolbarTitle(String categoryName) {
        if (!previousCategoryName.equals(categoryName)) {
            previousCategoryName = categoryName;
            toolbarTitle.setValue(categoryName);
            selectedUnitList.setValue(conversions.get(categoryName));
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
        Objects.requireNonNull(selectedFromUnits.getValue()).put(toolbarTitle.getValue(), unit);
    }

    public void setSelectedToUnit(Unit unit) {
        Objects.requireNonNull(selectedToUnits.getValue()).put(toolbarTitle.getValue(), unit);
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
        return Objects.requireNonNull(selectedFromUnits.getValue()).get(toolbarTitle.getValue());
    }

    public Unit getSelectedToUnit() {
        return Objects.requireNonNull(selectedToUnits.getValue()).get(toolbarTitle.getValue());
    }

    public LiveData<String> getToolbarTitle() {
        return toolbarTitle;
    }
}

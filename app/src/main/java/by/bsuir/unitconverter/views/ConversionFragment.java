package by.bsuir.unitconverter.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import by.bsuir.unitconverter.R;
import by.bsuir.unitconverter.models.Unit;
import by.bsuir.unitconverter.view_model.SharedViewModel;


public class ConversionFragment extends Fragment {

    private RadioGroup mGrpFrom, mGrpTo;
    SharedViewModel model;

    public ConversionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        final View rootView = inflater.inflate(R.layout.fragment_conversion, container, false);


        mGrpFrom = rootView.findViewById(R.id.radio_group_from);
        mGrpTo = rootView.findViewById(R.id.radio_group_to);
        FloatingActionButton fab = rootView.findViewById(R.id.swap_fab);


        mGrpFrom.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedLeftRadioButton = mGrpFrom.findViewById(checkedId);
            model.setSelectedFromUnit((Unit) selectedLeftRadioButton.getTag());
            model.setToValue();
        });

        mGrpTo.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRightRadioButton = mGrpTo.findViewById(checkedId);
            model.setSelectedToUnit((Unit) selectedRightRadioButton.getTag());
            model.setToValue();
        });

        fab.setOnClickListener(v -> swapUnits());

        model.getSelectedUnitList().observe(requireActivity(), this::replaceUnits);
        model.getFromValue().observe(requireActivity(), value -> model.setToValue());
        return rootView;
    }


    private void replaceUnits(List<Unit> units) {
        mGrpFrom.removeAllViews();
        mGrpTo.removeAllViews();

        for (int i = 0; i < units.size(); i++) {
            Unit u = units.get(i);
            mGrpFrom.addView(getRadioButton(u));
            mGrpTo.addView(getRadioButton(u));
        }


        Unit fromUnit = model.getSelectedFromUnit();
        Unit toUnit = model.getSelectedToUnit();


        RadioButton leftButton = mGrpFrom.findViewById(fromUnit.getId());
        leftButton.setChecked(true);
        RadioButton rightButton = mGrpTo.findViewById(toUnit.getId());
        rightButton.setChecked(true);
    }

    private RadioButton getRadioButton(Unit u) {
        RadioButton btn = (RadioButton) LayoutInflater.from(getActivity()).inflate(R.layout.unit_radio_button, null);

        btn.setId(u.getId());
        btn.setTag(u);
        btn.setText(u.getLabelResource());
        btn.setChecked(false);
        return btn;
    }

    private void swapUnits() {
        int fromId = mGrpFrom.getCheckedRadioButtonId();
        int toId = mGrpTo.getCheckedRadioButtonId();

        ((RadioButton) mGrpFrom.findViewById(toId)).setChecked(true);
        ((RadioButton) mGrpTo.findViewById(fromId)).setChecked(true);
    }

}
package by.bsuir.unitconverter.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.bsuir.unitconverter.R;
import by.bsuir.unitconverter.view_model.SharedViewModel;


public class NumPadFragment extends Fragment {


    public NumPadFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_numpad, container, false);
        SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);


        rootView.findViewById(R.id.button_one).setOnClickListener(item -> model.selectButton("1"));
        rootView.findViewById(R.id.button_two).setOnClickListener(item -> model.selectButton("2"));
        rootView.findViewById(R.id.button_three).setOnClickListener(item -> model.selectButton("3"));
        rootView.findViewById(R.id.button_four).setOnClickListener(item -> model.selectButton("4"));
        rootView.findViewById(R.id.button_five).setOnClickListener(item -> model.selectButton("5"));
        rootView.findViewById(R.id.button_six).setOnClickListener(item -> model.selectButton("6"));
        rootView.findViewById(R.id.button_seven).setOnClickListener(item -> model.selectButton("7"));
        rootView.findViewById(R.id.button_eight).setOnClickListener(item -> model.selectButton("8"));
        rootView.findViewById(R.id.button_nine).setOnClickListener(item -> model.selectButton("9"));
        rootView.findViewById(R.id.button_zero).setOnClickListener(item -> model.selectButton("0"));
        rootView.findViewById(R.id.button_dot).setOnClickListener(item -> model.selectButton("."));
        rootView.findViewById(R.id.button_division).setOnClickListener(item -> model.selectButton("/"));
        rootView.findViewById(R.id.button_multiply).setOnClickListener(item -> model.selectButton("*"));
        rootView.findViewById(R.id.button_minus).setOnClickListener(item -> model.selectButton("-"));
        rootView.findViewById(R.id.button_plus).setOnClickListener(item -> model.selectButton("+"));
        rootView.findViewById(R.id.button_clear).setOnClickListener(item -> model.selectButton("c"));
        rootView.findViewById(R.id.button_del).setOnClickListener(item -> model.selectButton("del"));
        rootView.findViewById(R.id.button_equal).setOnClickListener(item -> model.selectButton("="));

        return rootView;
    }

    public static NumPadFragment newInstance() {
        return new NumPadFragment();
    }
}
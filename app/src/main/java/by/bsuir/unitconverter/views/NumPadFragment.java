package by.bsuir.unitconverter.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.bsuir.unitconverter.R;


public class NumPadFragment extends Fragment {


    public NumPadFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numpad, container, false);
    }

    public static NumPadFragment newInstance() {
        return new NumPadFragment();
    }
}
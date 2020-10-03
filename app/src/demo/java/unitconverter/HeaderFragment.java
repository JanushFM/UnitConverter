package unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import by.bsuir.unitconverter.R;
import by.bsuir.unitconverter.view_model.SharedViewModel;
import by.bsuir.unitconverter.views.NumPadFragment;


public class HeaderFragment extends Fragment {

    private EditText editTextValueFrom;
    private EditText editTextValueTo;

    private NumPadFragment numPadFragment;

    public HeaderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        final View rootView = inflater.inflate(R.layout.fragment_header, container, false);
        editTextValueFrom = rootView.findViewById(R.id.value_from);
        editTextValueTo = rootView.findViewById(R.id.value_to);

        numPadFragment = NumPadFragment.newInstance();

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager(); // Return the FragmentManager for interacting with fragments associated with this activity.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_numPad, numPadFragment).hide(numPadFragment).commit(); // This back stack is managed by the Activity. It allows the user to return to the previous Fragment state by pressing the Back button.


        editTextValueFrom.setOnClickListener(view -> {
            if (numPadFragment.isVisible()) {
                closeFragment();
            } else {
                displayFragment();
            }
        });

        model.getButtonSelected().observe(requireActivity(), value -> editTextValueFrom.setText(value));
        model.getToValue().observe(requireActivity(), value -> editTextValueTo.setText(value));

        return rootView;
    }

    public void displayFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();  // Return the FragmentManager for interacting with fragments associated with this activity.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.show(numPadFragment).addToBackStack(null).commit(); // This back stack is managed by the Activity. It allows the user to return to the previous Fragment state by pressing the Back button.
    }

    public void closeFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();  // Return the FragmentManager for interacting with fragments associated with this activity.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.hide(numPadFragment).commit();
    }

}
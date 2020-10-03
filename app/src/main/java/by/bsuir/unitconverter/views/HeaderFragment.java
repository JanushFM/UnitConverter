package by.bsuir.unitconverter.views;




import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



import com.google.android.material.snackbar.Snackbar;

import by.bsuir.unitconverter.R;
import by.bsuir.unitconverter.view_model.SharedViewModel;


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
        //todo разобраться более как происходят транзакции
        fragmentTransaction.replace(R.id.fragment_numPad, numPadFragment).hide(numPadFragment).commit(); // This back stack is managed by the Activity. It allows the user to return to the previous Fragment state by pressing the Back button.


        editTextValueFrom.setOnClickListener(view -> {
            if (numPadFragment.isVisible()) {
                closeFragment();
            } else {
                displayFragment();
            }
        });
        editTextValueFrom.setOnLongClickListener(view -> {
            setDataToClipboard(editTextValueFrom.getText().toString());
            return true;
        });

        editTextValueTo.setOnLongClickListener(view -> {
            setDataToClipboard(editTextValueTo.getText().toString());
            return true;
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

    public void setDataToClipboard(String text) {
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Conversion", text);
        clipboard.setPrimaryClip(clip);
        showToast(requireActivity().findViewById(R.id.unit_list_container), R.string.text_was_copied_to_clipboard);
    }

    public void showToast(View parentView, int stringResourceID) {
        Snackbar sb = Snackbar.make(parentView, stringResourceID, Snackbar.LENGTH_SHORT);
        sb.show();
    }

}
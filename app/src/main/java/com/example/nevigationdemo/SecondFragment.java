package com.example.nevigationdemo;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nevigationdemo.ui.main.MainFragmentDirections;

import java.util.Locale;

public class SecondFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_second, container, false);
        Button button2=view.findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText=getView().findViewById(R.id.editTextSecond);
                SecondFragmentDirections.ActionSecondFragmentToMainFragment action = SecondFragmentDirections.actionSecondFragmentToMainFragment();
                action.setMessage1(editText.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        TextView argText =getView().findViewById(R.id.argText);
        SecondFragmentArgs args= SecondFragmentArgs.fromBundle(getArguments());
        String message =args.getMessage();
        argText.setText(message);
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
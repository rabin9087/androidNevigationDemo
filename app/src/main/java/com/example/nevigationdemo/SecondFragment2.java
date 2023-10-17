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

import com.example.nevigationdemo.ui.main.MainFragmentArgs;

public class SecondFragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_second2, container, false);
        Button button=view.findViewById(R.id.mainFragment2Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextSecondFragment=getView().findViewById(R.id.editTextSecond2);
                SecondFragment2Directions.ActionSecondFragment2ToMainFragment action =SecondFragment2Directions.actionSecondFragment2ToMainFragment();
                action.setMessage1(editTextSecondFragment.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView textViewSecond2=getView().findViewById(R.id.textViewSecond2);
        SecondFragment2Args args= SecondFragment2Args.fromBundle(getArguments());
        String message = args.getMessage3();
        textViewSecond2.setText(message);

    }

}
package com.example.nevigationdemo.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nevigationdemo.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

        Button button=getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userText=getView().findViewById(R.id.userText);
                MainFragmentDirections.ActionMainFragmentToSecondFragment action =MainFragmentDirections.actionMainFragmentToSecondFragment();
                action.setMessage(userText.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });
        Button buttonSecondFragment2 =getView().findViewById(R.id.secondFragment2Button);
        buttonSecondFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userText= getView().findViewById(R.id.userText);
                MainFragmentDirections.ActionMainFragmentToSecondFragment2 action=MainFragmentDirections.actionMainFragmentToSecondFragment2();
                action.setMessage3(userText.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        TextView textViewMain =getView().findViewById(R.id.textViewMain);
        MainFragmentArgs args=MainFragmentArgs.fromBundle(getArguments());
        String message1=args.getMessage1();
        textViewMain.setText(message1);

        TextView textView4=getView().findViewById(R.id.textViewMain);
        MainFragmentArgs args2=MainFragmentArgs.fromBundle(getArguments());
        String message2=args2.getMessage1();
        textView4.setText(message2);
    }
}
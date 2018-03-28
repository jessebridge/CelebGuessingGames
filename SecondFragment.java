package com.example.jesse.celebguessinggames;


import android.app.FragmentHostCallback;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.prefs.Preferences;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
View fragmentView;
View mainView;
ArrayAdapter<String> arrayAdapter;
int numguess;
GridView gridView;
SharedPreferences sharedPreferences;
Button button1;
Button button2;
Button button3;
Button button4;
Button button5;
    String[] Names = {
            "Lil Pump",
            "Lil Uzi",
            "Lil Wayne",
            "Lil Xan",
            "Lil Yachty"
    };

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_second, container);
        sharedPreferences = this.getActivity().getSharedPreferences("guesses", Context.MODE_PRIVATE);
        button1 = (Button)fragmentView.findViewById(R.id.button1);
        button2 = (Button)fragmentView.findViewById(R.id.button2);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

}

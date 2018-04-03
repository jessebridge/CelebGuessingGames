package com.example.jesse.celebguessinggames;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ImageView imageView;
    View fragmentView;
    int rand;
    private GridView gridView;
    ArrayAdapter<String> arrayAdapter;
    int imageposition;
    SharedPreferences sharedPreferences;
    int guessesInt;
    String[] Names = {
            "Lil Pump",
            "Lil Uzi",
            "Lil Wayne",
            "Lil Xan",
            "Lil Yachty"
    };
    int[] textarray = {
            R.mipmap.lilpump,
            R.mipmap.liluzi,
            R.mipmap.lilwayne,
            R.mipmap.lilxan,
            R.mipmap.lilyachty
    };
    TextView textView;

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_main, container);
        sharedPreferences = this.getActivity().getSharedPreferences("guesses", Context.MODE_PRIVATE);
        guessesInt = sharedPreferences.getInt("guesses", 4);
        gridView = (GridView) fragmentView.findViewById(R.id.guesses);
        imageView = (ImageView) fragmentView.findViewById(R.id.celebImage);
        textView = (TextView) fragmentView.findViewById(R.id.textView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clickedText = gridView.getItemAtPosition(i).toString();
                if (Arrays.asList(Names).indexOf(clickedText) == rand) {
                    rand = new Random().nextInt((guessesInt + 1));
                    imageView.setImageResource(textarray[rand]);
                    Toast.makeText(getActivity(), "Correct",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Incorrect",
                            Toast.LENGTH_SHORT).show();
                }

//                System.out.println(clickedText);


            }
        });
        SharedPreferences.OnSharedPreferenceChangeListener spchanged = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                guessesInt = sharedPreferences.getInt("guesses", 4);
                arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.guessgrid);

                for (int i = 0; i <= guessesInt; i++) {
                    arrayAdapter.add(Names[i]);
                }
                gridView.setAdapter(arrayAdapter);
            }

        };
        sharedPreferences.registerOnSharedPreferenceChangeListener(spchanged);


        if (savedInstanceState != null) {
            imageposition = savedInstanceState.getInt("Arraynum");
            imageView.setImageResource(textarray[imageposition]);
        } else {

            rand = new Random().nextInt(guessesInt);
            imageView.setImageResource(textarray[rand]);
        }

        arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.guessgrid);

        for (int i = 0; i <= guessesInt; i++) {
            arrayAdapter.add(Names[i]);
        }

        gridView.setAdapter(arrayAdapter);
        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Arraynum", rand);

    }


    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences = this.getActivity().getSharedPreferences("guesses", Context.MODE_PRIVATE);
        guessesInt = sharedPreferences.getInt("guesses", 4);
        arrayAdapter.clear();
        for (int i = 0; i <= guessesInt; i++) {
            arrayAdapter.add(Names[i]);
        }

        gridView.setAdapter(arrayAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        imageView.setImageDrawable(getResources().getDrawable(textarray[1]));
//        textView.setText(quotes[rand]);
    }
}

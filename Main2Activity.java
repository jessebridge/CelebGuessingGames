package com.example.jesse.celebguessinggames;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    int numguess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences = getSharedPreferences("guesses", MODE_PRIVATE);
    }


    public void numberOfChoicesTwo(View view) {
        numguess = 1;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
    }

    public void numberOfChoicesThree(View view) {
        numguess = 2;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
    }

    public void numberOfChoicesFour(View view) {
        numguess = 3;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
    }

    public void numberOfChoicesFive(View view) {
        numguess = 4;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
    }
}

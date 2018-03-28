package com.example.jesse.celebguessinggames;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    int numguess;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPreferences = getSharedPreferences("guesses", MODE_PRIVATE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        return true;
    }

    public void numberOfChoicesTwo(View view) {
        numguess = 1;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
        int number = sharedPreferences.getInt("guesses", 0);
        System.out.println(number);
    }
    public void numberOfChoicesThree(View view) {
        numguess = 2;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
        int number = sharedPreferences.getInt("guesses", 0);
        System.out.println(number);
    }

    public void numberOfChoicesFour(View view) {
        numguess = 3;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
        int number = sharedPreferences.getInt("guesses", 0);
        System.out.println(number);
    }

    public void numberOfChoicesFive(View view) {
        numguess = 4;
        sharedPreferences.edit().putInt("guesses", numguess).apply();
        int number = sharedPreferences.getInt("guesses", 0);
        System.out.println(number);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

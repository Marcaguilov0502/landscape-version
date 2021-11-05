package com.marcapps.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*  ToDo
        spring animations
        fling animations
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectActivity(View v) {
        switch (v.getId()) {
            case R.id.landscapeButton:
                Intent intent = new Intent(getApplicationContext(), LandscapeVersionActivity.class);
                startActivity(intent);
                break;
            case R.id.gestureButton:
                goToActivity(GesturesActivity.class);
                break;
            case R.id.animatorButton:
                goToActivity(AnimatorActivity.class);
                break;
            case R.id.layoutsButton:
                goToActivity(LayoutsActivity.class);
                break;
            case R.id.scrollViewButton:
                goToActivity(ScrollViewActivity.class);
                break;
            case R.id.addViewButton:
                goToActivity(AddViewsActivity.class);
                break;
            case R.id.spotifyScreenButton:
                goToActivity(SpotifyScreenActivity.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    public void goToActivity(Class c) {
        Intent intent = new Intent(getApplicationContext(), c);
        startActivity(intent);
    }

}
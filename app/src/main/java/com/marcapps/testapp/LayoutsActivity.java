package com.marcapps.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts_linear);

        countView = findViewById(R.id.countView);
    }

    private int count = 0;
    public TextView countView;

    public void toast(View view) {
        Toast.makeText(getApplicationContext(), "Count = "+count, Toast.LENGTH_SHORT).show();
    }

    public void add(View v) {
        count++;
        countView.setText(String.valueOf(count));
    }

    public void changeLayout(View v) {

        switch (v.getId()) {
            case R.id.linear:
                setContentView(R.layout.activity_layouts_relative);
                countView = findViewById(R.id.countView);
                countView.setText(String.valueOf(count));
                break;
            case R.id.relative:
                setContentView(R.layout.activity_layouts_constraint);
                countView = findViewById(R.id.countView);
                countView.setText(String.valueOf(count));
                break;
            case R.id.constraint:
                setContentView(R.layout.activity_layouts_linear);
                countView = findViewById(R.id.countView);
                countView.setText(String.valueOf(count));
                break;
        }

    }

}

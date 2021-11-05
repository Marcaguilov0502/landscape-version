package com.marcapps.testapp;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_views);

        grid = findViewById(R.id.grid);
    }

    GridLayout grid;
    int txt = 1;

    public void addButton(View v) {
        Button b = new Button(this);
        b.setText(String.valueOf(txt));
        int id = findUnusedId();
        b.setId(id);
        b.setWidth(50);
        b.setHeight(50);


        grid.addView(b,txt);
        txt++;

        int index = grid.indexOfChild(findViewById(id));

        TextView tv = findViewById(R.id.tv);
        tv.setText(String.valueOf(index));

    }

    public int findUnusedId() {
        int fID =0;
        while( findViewById(++fID) != null );
        return fID;
    }

}

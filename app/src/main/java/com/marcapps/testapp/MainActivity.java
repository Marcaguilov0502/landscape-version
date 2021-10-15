package com.marcapps.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String[] questions = new String[]{"!False", "!True"};
    public boolean[] answers = new boolean[]{true,false};
    public int index = 0;

    public TextView question;
    public Button trueButton;
    public Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
    }

    public void selectTrue(View v) {
        if (answers[index] == true) {
            toast("CORRECT!");
        } else {
            toast("INCORRECT!");
        }
    }

    public void selectFalse(View v) {
        if (answers[index] == false) {
            toast("CORRECT!");
        } else {
            toast("INCORRECT!");
        }
    }

    public void toast(String text) {
        Toast t = new Toast.makeText(1);
    }

    public void nextQuestion() {
        question.setText(questions[index]);
        index++;
    }

}
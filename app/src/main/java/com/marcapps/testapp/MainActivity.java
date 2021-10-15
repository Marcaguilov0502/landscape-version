package com.marcapps.testapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String[] questions = new String[]{"!False", "!True","Click false","Click true"};
    public boolean[] answers = new boolean[]{true,false,false,true};
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

        nextQuestion();
    }

    public void selectTrue(View v) {
        if (answers[index-1] == true) {
            toast("CORRECT!");
        } else {
            toast("INCORRECT!");
        }
        nextQuestion();
    }

    public void selectFalse(View v) {
        if (answers[index-1] == false) {
            toast("CORRECT!");
        } else {
            toast("INCORRECT!");
        }
        nextQuestion();
    }

    public void toast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        toast.show();
    }

    public void nextQuestion() {
        if (index < answers.length) {
            question.setText(questions[index]);
            index++;
        } else {
            question.setText("END");
        }

    }

}
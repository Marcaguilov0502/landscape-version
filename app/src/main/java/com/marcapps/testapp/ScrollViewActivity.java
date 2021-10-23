package com.marcapps.testapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        commentButton = findViewById(R.id.commentButton);
        commentSection = findViewById(R.id.commentSection);
        comment = findViewById(R.id.comment);

    }

    public Button commentButton;
    public TextView commentSection;
    public EditText comment;
    boolean commenting = false;

    public void comment(View v) {

        String text = comment.getText().toString();

        if (commenting) {

            if (!text.isEmpty()) {
                commentSection.append("\n"+text+"\n");

            }
            hideKeyboard();
            comment.setText("");
            commentButton.setText("comment");
            comment.setVisibility(View.GONE);
            commenting = false;
        } else {
            commentButton.setText("save");
            comment.setVisibility(View.VISIBLE);
            commenting = true;

            comment.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(comment, InputMethodManager.SHOW_IMPLICIT);

        }
    }

    public void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}

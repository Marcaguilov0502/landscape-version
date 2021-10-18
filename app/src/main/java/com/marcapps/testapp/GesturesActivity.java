package com.marcapps.testapp;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class GesturesActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
        action = findViewById(R.id.action);
        position = findViewById(R.id.position);
    }

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;
    private TextView action;
    private TextView position;

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        setActionText( "Fling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        setActionText( "LongPress");
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        setPositionText("X = "+x+" , Y = "+y);
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        setActionText( "Scroll");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        setActionText( "DoubleTapEvent");
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        setPositionText("X = "+x+" , Y = "+y);
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        setActionText( "SingleTapConfirmed");
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        setPositionText("X = "+x+" , Y = "+y);
        return true;
    }

    public void setActionText (String text) {
        action.setText("Action: " + text);
    }

    public void setPositionText (String text) {
        position.setText("Position: " + text);
    }

    public void toast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

}

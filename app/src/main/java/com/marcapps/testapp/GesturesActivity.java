package com.marcapps.testapp;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

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
        origin = findViewById(R.id.origin);
        distance = findViewById(R.id.distance);
        angle = findViewById(R.id.angle);
    }

    private GestureDetectorCompat mDetector;
    private TextView action;
    private TextView position;
    private TextView origin;
    private TextView distance;
    private TextView angle;

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
        updateAction( "Fling");

        int x1 = (int) event1.getAxisValue(MotionEvent.AXIS_X);
        int y1 = (int) event1.getAxisValue(MotionEvent.AXIS_Y);
        int x2 = (int) event2.getAxisValue(MotionEvent.AXIS_X);
        int y2 = (int) event2.getAxisValue(MotionEvent.AXIS_Y);

        int dx = x2 - x1;
        int dy = y2 - y1;

        updatePosition(x2,y2);
        updateOrigin(x1,y1);
        updateDistance(dx,dy);
        updateAngle(dx,dy);

        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        updateAction( "LongPress");
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        updatePosition(x,y);
        origin.setText("");
        distance.setText("");
        angle.setText("");
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        updateAction( "Scroll");

        int x1 = (int) event1.getAxisValue(MotionEvent.AXIS_X);
        int y1 = (int) event1.getAxisValue(MotionEvent.AXIS_Y);
        int x2 = (int) event2.getAxisValue(MotionEvent.AXIS_X);
        int y2 = (int) event2.getAxisValue(MotionEvent.AXIS_Y);

        int dx = x2 - x1;
        int dy = y2 - y1;

        updatePosition(x2,y2);
        updateOrigin(x1,y1);
        updateDistance(dx,dy);
        updateAngle(dx,dy);

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
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        updateOrigin(x,y);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        updateAction( "DoubleTap");
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        updatePosition(x,y);
        distance.setText("");
        angle.setText("");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        updateAction( "SingleTap");
        int x = (int) event.getAxisValue(MotionEvent.AXIS_X);
        int y = (int) event.getAxisValue(MotionEvent.AXIS_Y);
        updatePosition(x,y);
        origin.setText("");
        distance.setText("");
        angle.setText("");
        return true;
    }

    public void updateAction(String text) {
        action.setText("Action: " + text);
    }

    public void updatePosition(int x, int y) {
        position.setText("Position: X="+x+" , Y="+y);
    }

    public void updateOrigin(int x, int y) {
        origin.setText("Origin: X="+x+" , Y="+y);
    }

    public void updateDistance(int dx, int dy) {
        int total = (int) Math.sqrt((dx*dx)+(dy^dy));
        distance.setText("Distance: X="+dx+" , Y="+dy+" , T="+total);
    }

    public void updateAngle(double dx, double dy) {
        if (dx != 0) {
            double alfa = (Math.atan(dy/dx))*57.2958;
            if (dx < 0) { alfa += 180;}
            else if (dy < 0) {alfa+=360;}
            angle.setText("Angle: " + (int) alfa + "º");
        }
    }

    public void toast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

}

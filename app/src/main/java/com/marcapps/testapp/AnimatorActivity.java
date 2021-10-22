package com.marcapps.testapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        value = findViewById(R.id.value);

    }

    private TextView value;
    private int v = 0;

    public void animate(View view) {

        switch (view.getId()) {
            case R.id.objectAnimator:
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 300f);
                animator.setDuration(2000);
                animator.start();
                break;

            case R.id.valueAnimator:
                ValueAnimator animation = ValueAnimator.ofInt(v, v+100);
                animation.setDuration(1000);
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator va) {
                        value.setText(animation.getAnimatedValue().toString());
                    }
                });
                animation.start();
                v+=100;
                break;

            case R.id.animatorSet:
                ObjectAnimator fall = ObjectAnimator.ofFloat(view, "translationY", 600f);
                fall.setDuration(500);
                ObjectAnimator squashX = ObjectAnimator.ofFloat(view, "scaleX", 1.3f);
                ObjectAnimator squashY = ObjectAnimator.ofFloat(view, "scaleY", 0.6f);
                squashX.setDuration(200);
                squashY.setDuration(200);
                squashX.setStartDelay(300);
                squashY.setStartDelay(300);
                ObjectAnimator rescaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f);
                ObjectAnimator rescaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f);
                rescaleX.setDuration(400);
                rescaleY.setDuration(400);
                ObjectAnimator up = ObjectAnimator.ofFloat(view, "translationY", 0f);

                AnimatorSet bouncer = new AnimatorSet();
                bouncer.play(fall).with(squashX);
                bouncer.play(squashY).with(squashX);
                bouncer.play(rescaleX).after(fall);
                bouncer.play(rescaleY).with(rescaleX);
                bouncer.play(up).with(rescaleX);

                bouncer.start();
                break;

            case R.id.springAnimation:
                //SpringAnimation springAnim = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0);

        }


    }



}

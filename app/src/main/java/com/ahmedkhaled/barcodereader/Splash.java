package com.ahmedkhaled.barcodereader;

import android.animation.Animator;
import android.content.Intent;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    ImageView logo;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView) findViewById(R.id.logo);
        name = (TextView) findViewById(R.id.name);

        name.setVisibility(View.INVISIBLE);

        doAnimation();
        thread.start();
    }


    void doAnimation(){
        logo.animate().setDuration(1500).rotation(360)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(animatorListener)
                .start();
    }


     Animator.AnimatorListener animatorListener=new Animator.AnimatorListener() {
         @Override
         public void onAnimationStart(Animator animator) {

         }

         @Override
         public void onAnimationEnd(Animator animator) {
            name.setVisibility(View.VISIBLE);
         }

         @Override
         public void onAnimationCancel(Animator animator) {

         }

         @Override
         public void onAnimationRepeat(Animator animator) {

         }
     };


    Thread thread =new Thread(){

        @Override
        public void run() {
            try {
                sleep(2200);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
            catch (InterruptedException e) {

            }


        }
    };
}

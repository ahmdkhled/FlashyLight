package com.ahmdkhled.flashy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Splash extends AppCompatActivity {

    RelativeLayout container;
    int y;
    ImageView circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        container = (RelativeLayout) findViewById(R.id.activity_splash);
        gethight();


        circle= (ImageView) findViewById(R.id.img);
        circle.setColorFilter(Color.WHITE);

        animate();
        thread.start();


    }

    public void animate(){

        circle.animate().setDuration(2000).translationY(y/2).setInterpolator(new BounceInterpolator());

    }

    public void gethight(){
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        y=displayMetrics.heightPixels;
    }

    Thread thread =new Thread(){

        @Override
        public void run() {
            super.run();
            try {
                sleep(2500);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    };



}

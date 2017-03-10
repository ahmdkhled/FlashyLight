package com.ahmdkhled.flashy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;   // switch button
    boolean isOn =false;
    CamHelper camHelper;
    Sfx sfx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.button);
        sfx =new Sfx(this);

        if(!CheckFlash.isavailable(this)){

            Toast.makeText(getApplicationContext(),R.string.notSupported,Toast.LENGTH_SHORT).show();
            finish();

        }else {
            camHelper = new CamHelper(this);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOn =!isOn;
                if(isOn){
                    imageView.setImageResource(R.drawable.onswitch);
                    sfx.playSfx();
                    camHelper.openFlash();
                }else {
                    imageView.setImageResource(R.drawable.offswitch);
                    sfx.playSfx();
                   camHelper.closeFlash();
                }
            }
        });


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            camHelper.release();
        } catch (Exception e) {

        }
    }
}

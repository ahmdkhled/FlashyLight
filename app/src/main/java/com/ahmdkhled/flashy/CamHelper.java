package com.ahmdkhled.flashy;

import android.content.Context;
import android.hardware.Camera;
import android.widget.Toast;



public class CamHelper {


    Camera cam;
    Camera.Parameters parameters;

    public CamHelper(Context context) {
        try {
            cam = Camera.open();
            parameters = cam.getParameters();
        }catch (Exception e){
            Toast.makeText(context,"error openning camera ",Toast.LENGTH_SHORT).show();
        }
    }


    public void openFlash(){

        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(parameters);
        cam.startPreview();


    }

    public void closeFlash(){

        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        cam.setParameters(parameters);
        cam.stopPreview();
    }

    public void release(){
        if(cam!=null){
            cam.release();
            cam=null;
            }
    }


}

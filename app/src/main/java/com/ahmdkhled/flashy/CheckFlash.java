package com.ahmdkhled.flashy;

import android.content.Context;
import android.content.pm.PackageManager;



 class CheckFlash  {


     static Boolean isavailable(Context context){
     return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

}

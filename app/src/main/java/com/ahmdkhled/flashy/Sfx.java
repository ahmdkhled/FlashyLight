package com.ahmdkhled.flashy;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Ahmed Khaled on 3/10/2017.
 */

public class Sfx {

    private SoundPool soundPool;
    private int switchSound;

    public Sfx(Context context) {
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        switchSound = soundPool.load(context, R.raw.swichsfx, 1);
    }

    public void playSfx(){
        soundPool.play(switchSound,1.0f,1.0f,1,0,1.0f);
    }

}

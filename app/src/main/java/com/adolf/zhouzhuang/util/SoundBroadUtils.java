package com.adolf.zhouzhuang.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.net.URI;

/**
 * Created by gpp on 2016/9/8 0008.
 */
public class SoundBroadUtils {

    private static SoundBroadUtils mInstance;

    public static SoundBroadUtils getInstance(){
        if(mInstance == null){
            mInstance = new SoundBroadUtils();
        }
        return mInstance;
    }

    private SoundBroadUtils(){}

    private MediaPlayer mp;

    private boolean is_palying = false;
    private int bocast_time = 1;
    private final int MAX_BROAD_TIME = 2;


    public synchronized void playSound(final Context context, final String filePath) {
        if(is_palying){
            return;
        }
        is_palying = true;
        playBroadSound(context,filePath);
    }
    public void  pauseSound(boolean is_pause){
        if(mp != null){
        if(is_pause){
            mp.start();
        }else{
            mp.pause();
        }
        }
    }
    private void playBroadSound(final Context context, final String filePath){
        if(mp != null){
            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(context, Uri.parse(filePath));
        try {
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    bocast_time++;
                    if (bocast_time < MAX_BROAD_TIME + 1){
                        playBroadSound(context,filePath);
                    }else{
                        bocast_time = 1;
                        is_palying = false;
                        mp.release();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            bocast_time = 1;
            is_palying = false;
            mp.release();
        }
    }

    public static String getLogTag() {
        return SoundBroadUtils.class.getSimpleName();
    }


}

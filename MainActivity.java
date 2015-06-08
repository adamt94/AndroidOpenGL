package com.opengl.adam.androidopengl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by adam on 08-Jun-15.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo info = am.getDeviceConfigurationInfo();
        //check it can support
        boolean supportES2 = (info.reqGlEsVersion >=0x20000);

        if(supportES2){
            //this does all the drawing
            MainRenderer mainRenderer = new MainRenderer();

            MainSurfaceView mainSurfaceView = new MainSurfaceView(this);
            mainSurfaceView.setEGLContextClientVersion(2);
            mainSurfaceView.setRenderer(mainRenderer);
            //set it to the screen
            this.setContentView(mainSurfaceView);
        }else{
            Log.e("OpenGLES 2", "Your Device doesn't suppoer ES2. ("+ info.reqGlEsVersion+")");
        }

    }
}

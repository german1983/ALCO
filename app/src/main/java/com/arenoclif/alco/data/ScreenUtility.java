package com.arenoclif.alco.data;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by German on 23/11/2014.
 */
public class ScreenUtility {

    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public ScreenUtility(Activity activity){
        this.activity = activity;

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = activity.getResources().getDisplayMetrics().density;
        dpHeight = outMetrics.heightPixels / density;
        dpWidth = outMetrics.widthPixels / density;
    }

    public float getDpWidth () { return dpWidth;}
    public float getDpHeight () { return dpHeight;}
}

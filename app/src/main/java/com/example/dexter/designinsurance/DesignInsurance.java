package com.example.dexter.designinsurance;

import android.app.Application;

/**
 * Created by dexter on 5/7/2018.
 */

public class DesignInsurance extends Application {

    @Override
    public void onCreate() {


        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "DEFAULT", "fonts/oredoo.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "MONOSPACE", "fonts/oredoo.ttf");
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/oredoo.ttf");
    }
}

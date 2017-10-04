package com.b05studio.recotrip.application;

import android.app.Application;

import com.b05studio.recotrip.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by young on 2017-10-04.
 */

public class RecoTripApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/NOTOSANSKR-REGULAR.OTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}

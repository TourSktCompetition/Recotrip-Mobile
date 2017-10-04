package com.b05studio.recotrip.application;

import android.app.Application;

import com.b05studio.recotrip.R;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by young on 2017-10-04.
 */

public class RecoTripApplication extends Application {

    private static Retrofit retrofit = null;
    private static final String RecoTrip_BASIC_URL = "";

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/NOTOSANSKR-REGULAR.OTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(new OkHttpClient().newBuilder()
                            .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .addNetworkInterceptor(new StethoInterceptor()).build())
                    .baseUrl(RecoTrip_BASIC_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

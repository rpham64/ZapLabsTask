package com.rpham64.android.zaplabstask.ui;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.rpham64.android.zaplabstask.network.RestClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rudolf on 6/21/2017.
 */

public class ApplicationController extends Application {

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    private static ApplicationController sInstance;

    private OkHttpClient mOkHttpClient;
    private RestClient mRestClient;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        mOkHttpClient = new OkHttpClient.Builder()
//                .addNetworkInterceptor(new StethoInterceptor())
//                .addInterceptor(loggingInterceptor)
//                .build();
    }

    public RestClient getRestClient() {

        if (mRestClient == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mRestClient = retrofit.create(RestClient.class);
        }

        return mRestClient;
    }

    public static ApplicationController getInstance() {
        if (sInstance == null) {
            sInstance = new ApplicationController();
        }
        return sInstance;
    }
}

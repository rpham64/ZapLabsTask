package com.rpham64.android.zaplabstask;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
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
        sInstance = this;
        Stetho.initializeWithDefaults(this);

        mOkHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    public RestClient getRestClient() {

        if (mRestClient == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(mOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mRestClient = retrofit.create(RestClient.class);
        }

        return mRestClient;
    }

    public static ApplicationController getInstance() {
        return sInstance;
    }
}

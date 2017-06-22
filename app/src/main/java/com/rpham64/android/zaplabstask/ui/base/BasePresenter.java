package com.rpham64.android.zaplabstask.ui.base;

import android.support.annotation.CallSuper;

import com.rpham64.android.zaplabstask.network.RestClient;
import com.rpham64.android.zaplabstask.ui.ApplicationController;

/**
 * Created by Rudolf on 5/3/2017.
 */

public class BasePresenter<T> implements IPresenter<T> {

    private T mView;

    @Override
    @CallSuper
    public void onResume() {

    }

    @Override
    @CallSuper
    public void onPause() {

    }

    @Override
    @CallSuper
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public T getView() {
        return mView;
    }

    @Override
    public RestClient getRestClient() {
        return ApplicationController.getInstance().getRestClient();
    }
}
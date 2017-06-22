package com.rpham64.android.zaplabstask.ui.base;

import com.rpham64.android.zaplabstask.network.RestClient;

/**
 * Created by Rudolf on 5/3/2017.
 */

public interface IPresenter<T> {

    void attachView(T mvpView);

    void detachView();
    T getView();

    void onResume();
    void onPause();
    void onDestroy();

    RestClient getRestClient();
}

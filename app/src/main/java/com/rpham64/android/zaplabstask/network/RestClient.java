package com.rpham64.android.zaplabstask.network;

import com.rpham64.android.zaplabstask.models.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rudolf on 6/21/2017.
 */

public interface RestClient {

    @GET("photos/")
    Call<List<ListItem>> getListItems();

}

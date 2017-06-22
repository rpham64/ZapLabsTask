package com.rpham64.android.zaplabstask.ui.list;

import com.rpham64.android.zaplabstask.models.ListItem;
import com.rpham64.android.zaplabstask.ui.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rudolf on 6/21/2017.
 */

public class ListPresenter extends BasePresenter<ListPresenter.View> {

    public ListPresenter() {

    }

    public void getListItems() {
        Call<List<ListItem>> call = getRestClient().getListItems();
        call.enqueue(new Callback<List<ListItem>>() {
            @Override
            public void onResponse(Call<List<ListItem>> call, Response<List<ListItem>> response) {
                List<ListItem> itemList = response.body();
                getView().showList(itemList);
            }

            @Override
            public void onFailure(Call<List<ListItem>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public interface View {
        void showList(List<ListItem> itemList);
    }
}

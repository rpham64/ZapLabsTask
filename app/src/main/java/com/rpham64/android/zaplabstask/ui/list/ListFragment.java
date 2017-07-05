package com.rpham64.android.zaplabstask.ui.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpham64.android.zaplabstask.R;
import com.rpham64.android.zaplabstask.models.ListItem;
import com.rpham64.android.zaplabstask.ui.adapters.ListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Rudolf on 6/21/2017.
 */

public class ListFragment extends Fragment implements ListPresenter.View {

    @BindView(R.id.recycler_view_list_photos) RecyclerView recyclerView;

    private Unbinder mUnbinder;
    private ListPresenter mPresenter;
    private ListAdapter mAdapter;

    private List<ListItem> mItemList;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mPresenter = new ListPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_photos, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mPresenter.attachView(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        if (mItemList == null) {
            mPresenter.getListItems();
        } else {
            showList(mItemList);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        mPresenter.detachView();
    }

    @Override
    public void showList(List<ListItem> itemList) {

        mItemList = itemList;

        if (isAdded()) {
            mAdapter = new ListAdapter(getContext(), itemList);
            recyclerView.setAdapter(mAdapter);
        }
    }
}

package com.rpham64.android.zaplabstask.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rpham64.android.zaplabstask.R;
import com.rpham64.android.zaplabstask.models.ListItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rudolf on 6/21/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mContext;
    private List<ListItem> mItems;

    public ListAdapter(Context context, List<ListItem> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_photo, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        ListItem listItem = mItems.get(position);

        // Set listItem and title for list item
        Picasso.with(mContext).load(listItem.thumbnailUrl).into(holder.imgThumbnail);

        String title = new StringBuilder()
                .append(position)
                .append(" - ")
                .append(listItem.title)
                .toString();

        holder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        if (mItems == null) {
            return 0;
        }
        return mItems.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_thumbnail) ImageView imgThumbnail;
        @BindView(R.id.txt_title) TextView txtTitle;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

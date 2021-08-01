package com.vondear.tools;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.vondear.tools.scaner.ActivityScanerCode;
import com.vondear.vontools.VonActivityUtils;
import com.vondear.vontools.VonDeviceUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vonde on 2016/11/13.
 */

public class AdapterRecyclerViewMain extends RecyclerView.Adapter<AdapterRecyclerViewMain.ViewHolder> {

    private int mScreenWidth, mItemWidth, mItemHeight;
    private Context context;
    private List<MainItem> mValues;

    public AdapterRecyclerViewMain(List<MainItem> items) {
        mValues = items;
    }

    @Override
    public AdapterRecyclerViewMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_main, parent, false);
        context = view.getContext();
        mScreenWidth = VonDeviceUtils.getScreenWidth(context) > VonDeviceUtils.getScreenHeight(context) ? VonDeviceUtils.getScreenHeight(context) : VonDeviceUtils.getScreenWidth(context);
        mItemWidth = (mScreenWidth - 20) / 3;
        mItemHeight = mItemWidth;
        GridLayoutManager.LayoutParams layoutParams = new GridLayoutManager.LayoutParams(mItemWidth, mItemHeight);
        view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mItem = mValues.get(position);

        holder.tvName.setText(holder.mItem.getName());

        Glide.with(context).
                load(holder.mItem.getImage()).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                thumbnail(0.5f).
                priority(Priority.HIGH).
                placeholder(R.drawable.pikachu_sit).
                error(R.drawable.pikachu_sit).
                fallback(R.drawable.pikachu_sit).
                into(holder.imageView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        VonActivityUtils.skipActivity(context,ActivityVonPhoto.class);
                        break;
                    case 1:
                        VonActivityUtils.skipActivity(context,ActivityScanerCode.class);
                        break;

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.tv_name)
        TextView tvName;

        public MainItem mItem;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }
}

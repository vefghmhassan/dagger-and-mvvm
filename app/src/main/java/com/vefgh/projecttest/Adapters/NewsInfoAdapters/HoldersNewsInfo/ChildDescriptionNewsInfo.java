package com.vefgh.projecttest.Adapters.NewsInfoAdapters.HoldersNewsInfo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vefgh.projecttest.Adapters.NewsInfoAdapters.HoldersNewsInfo.ImageHolder;
import com.vefgh.projecttest.Adapters.NewsInfoAdapters.HoldersNewsInfo.TextHolder;
import com.vefgh.projecttest.Constants.Constant;
import com.vefgh.projecttest.Models.NewsInfo;
import com.vefgh.projecttest.R;

import java.util.List;

public class ChildDescriptionNewsInfo extends RecyclerView.Adapter {
    List<NewsInfo.DescBean> descBean;

    public final int TEXTTYPE = 0;
    public final int IMAGE_TYPE = 1;


    public ChildDescriptionNewsInfo(List<NewsInfo.DescBean> descBean) {
        this.descBean = descBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TEXTTYPE:
                return new TextHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, null));
            case IMAGE_TYPE:
                return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof TextHolder) {
            ((TextHolder) holder).text.setText(descBean.get(position).getData());
        } else if (holder instanceof ImageHolder) {
            String  url=Constant.Product_IMAGE_URL+descBean.get(position).getData();
            Glide.with(holder.itemView.getContext()).load(url).into(((ImageHolder) holder).image);

        }


    }

    @Override
    public int getItemCount() {
        return descBean.size();
    }

    @Override
    public int getItemViewType(int position) {

        switch (descBean.get(position).getType()) {
            case "text":
                return TEXTTYPE;
            case "image":
                return IMAGE_TYPE;
            default:
                return 0;


        }
    }

}

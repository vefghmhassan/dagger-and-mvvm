package com.vefgh.projecttest.Adapters.NewsInfoAdapters.HoldersNewsInfo;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vefgh.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.image)
  public   ImageView image;
    public ImageHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }
}

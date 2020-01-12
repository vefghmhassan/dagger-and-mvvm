package com.vefgh.projecttest.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vefgh.projecttest.Constants.Constant;
import com.vefgh.projecttest.Models.News;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.Utils.FragmentChanger;
import com.vefgh.projecttest.Views.Ui.Activitys.MainActivity;
import com.vefgh.projecttest.Views.Ui.Fragments.NewsFragment;
import com.vefgh.projecttest.Views.Ui.Fragments.NewsInfoFragment;

import java.util.Collection;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.HolderNews> {
    News news;


    public AdapterNews(News news) {
        this.news = news;
    }

    @NonNull
    @Override
    public HolderNews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderNews(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderNews holder, int position) {
        Glide.with(holder.itemView.getContext()).load(Constant.Product_IMAGE_URL + news.getNewPost().get(position).getImage()).into(holder.image);
        holder.title.setText(news.getNewPost().get(position).getTitle());
        holder.itemView.setOnClickListener(new OnclickCustom(news.getNewPost().get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return news.getNewPost().size();
    }

    public class HolderNews extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;

        public HolderNews(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class OnclickCustom implements View.OnClickListener {
        int id;

        public OnclickCustom(int id) {
            this.id = id;
        }

        @Override
        public void onClick(View v) {
            FragmentChanger.init(MainActivity.self).setCommitBackStack(new NewsInfoFragment(id),"");
        }
    }
}

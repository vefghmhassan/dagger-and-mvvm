package com.vefgh.projecttest.Adapters.NewsInfoAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vefgh.projecttest.Adapters.AdapterNews;
import com.vefgh.projecttest.Constants.Constant;
import com.vefgh.projecttest.Models.Search;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.Utils.FragmentChanger;
import com.vefgh.projecttest.Views.Ui.Activitys.MainActivity;
import com.vefgh.projecttest.Views.Ui.Fragments.NewsInfoFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.HolderSearch> {
    List<Search.ResultBean> listSearch;

    public AdapterSearch(List<Search.ResultBean> listSearch) {
        this.listSearch = listSearch;
    }

    @NonNull
    @Override
    public HolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderSearch(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSearch holder, int position) {
        Glide.with(holder.itemView.getContext()).load(Constant.Product_IMAGE_URL + listSearch.get(position).getImage()).into(holder.image);
        holder.title.setText(listSearch.get(position).getTitle());
        holder.itemView.setOnClickListener(new OnclickCustom(listSearch.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return listSearch.size();
    }

    public class HolderSearch extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;

        public HolderSearch(@NonNull View itemView) {
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

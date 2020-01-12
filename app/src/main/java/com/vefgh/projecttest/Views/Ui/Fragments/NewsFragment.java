package com.vefgh.projecttest.Views.Ui.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vefgh.projecttest.Adapters.AdapterNews;
import com.vefgh.projecttest.Models.News;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.ViewModels.NewsViewModel;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    @BindView(R.id.recycle_news)
    RecyclerView recycleNews;

    NewsViewModel newsViewModel;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        recycleNews.setLayoutManager(new LinearLayoutManager(getContext()));
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.getnewsData().observe(this, news -> {
            Collections.reverse(news.getNewPost());
            recycleNews.setAdapter(new AdapterNews(news));

        });
    }
}

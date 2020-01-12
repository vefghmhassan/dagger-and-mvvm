package com.vefgh.projecttest.Views.Ui.Fragments;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.vefgh.projecttest.Adapters.NewsInfoAdapters.AdapterNewsInfo;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.Utils.ExoPlay;
import com.vefgh.projecttest.Utils.FragmentChanger;
import com.vefgh.projecttest.ViewModels.NewsInfoViewModel;
import com.vefgh.projecttest.Views.Ui.Activitys.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsInfoFragment extends Fragment {
    NewsInfoViewModel newsInfoViewModel;
    @BindView(R.id.recycle_news_info)
    RecyclerView recycleNewsInfo;
    private int id;

    public static PlayerView playerView;

    public NewsInfoFragment(int id) {
        this.id = id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        recycleNewsInfo.setLayoutManager(new LinearLayoutManager(getContext()));
        newsInfoViewModel = ViewModelProviders.of(this).get(NewsInfoViewModel.class);
        responseServer();

        //  back();
    }

    public void responseServer() {
        newsInfoViewModel.getnewsinfo(id).observe(this, newsInfo -> recycleNewsInfo.setAdapter(new AdapterNewsInfo(newsInfo)));
    }

//    void back() {
//        this.getView().setFocusableInTouchMode(true);
//        this.getView().requestFocus();
//        this.getView().setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    if (playerView != null&&ExoPlay.player!=null) {
//
//                            ExoPlay.player.stop();
//                            ExoPlay.player.release();
//                            ExoPlay.player=null;
//
//
//                    }
//                    FragmentChanger.init(MainActivity.self).setCommitBackStack(new NewsFragment(),"");
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

    @Override
    public void onStop() {
        super.onStop();
        if (playerView != null && ExoPlay.player != null) {

            ExoPlay.player.stop();
            ExoPlay.player.release();
            ExoPlay.player = null;


        }
    }
}

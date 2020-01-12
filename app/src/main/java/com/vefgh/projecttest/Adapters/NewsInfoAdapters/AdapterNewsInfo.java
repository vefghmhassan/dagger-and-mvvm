package com.vefgh.projecttest.Adapters.NewsInfoAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.vefgh.projecttest.Adapters.NewsInfoAdapters.HoldersNewsInfo.ChildDescriptionNewsInfo;
import com.vefgh.projecttest.Constants.Constant;
import com.vefgh.projecttest.Models.NewsInfo;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.Utils.ExoPlay;
import com.vefgh.projecttest.Views.Ui.Fragments.NewsInfoFragment;

import java.util.List;

public class AdapterNewsInfo extends RecyclerView.Adapter {
    NewsInfo newsInfo;
    private final int MEDYA_TYPE = 0;
    private final int SLIDER_TYPE = 1;
    private final int DESCREIPTION_TYPE = 2;

    public AdapterNewsInfo(NewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case MEDYA_TYPE:
                return new MediaPlayer(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, null));
            case SLIDER_TYPE:
                return new Slider(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, null));
            case DESCREIPTION_TYPE:
                return new Description(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_child, null));
            default:
                return new Line(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_line, null));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Description) {
            ((Description) holder).recycler.setAdapter(new ChildDescriptionNewsInfo(newsInfo.getDesc()));
        } else if (holder instanceof MediaPlayer) {
            //     ((MediaPlayer) holder).
            ExoPlay.intializ(((MediaPlayer) holder).playerView, Constant.VIDEO_URL + newsInfo.getMedia(), holder.itemView.getContext());
        } else if (holder instanceof Slider) {
            setSlider(newsInfo.getImages(), holder.itemView.getContext(), ((Slider) holder).slider);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case 0:
                if (!newsInfo.getMedia().equals("")) {
                    return MEDYA_TYPE;
                } else {
                    return SLIDER_TYPE;
                }
            case 2:
                return DESCREIPTION_TYPE;
            default:
                return 3;
        }

    }

    private class MediaPlayer extends RecyclerView.ViewHolder {
        PlayerView playerView;

        public MediaPlayer(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.video);
            NewsInfoFragment.playerView=playerView;
        }
    }

    private class Slider extends RecyclerView.ViewHolder {
        private SliderLayout slider;

        public Slider(@NonNull View itemView) {
            super(itemView);
            slider = itemView.findViewById(R.id.slider);
        }
    }

    public class Description extends RecyclerView.ViewHolder {
        RecyclerView recycler;

        public Description(@NonNull View itemView) {
            super(itemView);
            recycler = itemView.findViewById(R.id.child_recyclerview);
            recycler.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }
    }

    public class Line extends RecyclerView.ViewHolder {

        public Line(@NonNull View itemView) {
            super(itemView);
        }
    }

    private void setSlider(List<NewsInfo.ImagesBean> images, Context context, SliderLayout slider) {
        for (NewsInfo.ImagesBean image : images) {
            TextSliderView textSliderView = new TextSliderView(context);
            textSliderView
                    .description("")
                    .image(Constant.POST_IMAGE_THUMB_URL + image.getFilename())
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            slider.addSlider(textSliderView);
        }
    }

}

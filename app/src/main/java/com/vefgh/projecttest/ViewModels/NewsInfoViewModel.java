package com.vefgh.projecttest.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vefgh.Componets.DaggerNewsInfoComponet;
import com.vefgh.Componets.NewsInfoComponet;
import com.vefgh.projecttest.Models.NewsInfo;
import com.vefgh.projecttest.Moduls.NewsInfoModule;
import com.vefgh.projecttest.Repository.NewsInfoReporitory;

import javax.inject.Inject;


public class NewsInfoViewModel extends AndroidViewModel {
    @Inject
    NewsInfoReporitory newsInfoReporitory;
    LiveData<NewsInfo> news;

    public NewsInfoViewModel(@NonNull Application application) {
        super(application);
        generateRepository();
    }

    private void generateRepository() {
        NewsInfoComponet newsInfoModul = DaggerNewsInfoComponet.builder().newsInfoModule(new NewsInfoModule()).build();
        newsInfoModul.inject(this);

    }

    public LiveData<NewsInfo> getnewsinfo(int id) {
        return news = newsInfoReporitory.getNewsInfo(id);
    }
}

package com.vefgh.projecttest.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vefgh.Componets.DaggerNewsComponet;
import com.vefgh.Componets.NewsComponet;
import com.vefgh.projecttest.Models.News;
import com.vefgh.projecttest.Moduls.NewsModule;
import com.vefgh.projecttest.Repository.NewsRepository;

import javax.inject.Inject;

public class NewsViewModel extends AndroidViewModel {
    @Inject
    NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        daggerGenerate();
    }

    private void daggerGenerate() {
       NewsComponet newsComponet= DaggerNewsComponet.builder().newsModule(new NewsModule()).build();
       newsComponet.inject(this);
    }
    public LiveData<News>getnewsData(){
        return newsRepository.getNews();
    }
}

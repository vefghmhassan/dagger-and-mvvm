package com.vefgh.projecttest.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vefgh.Componets.DaggerSearchComponet;
import com.vefgh.Componets.SearchComponet;
import com.vefgh.projecttest.Models.Search;
import com.vefgh.projecttest.Moduls.SearchModule;
import com.vefgh.projecttest.Repository.SearchRepository;

import javax.inject.Inject;

public class SearchViewModel extends AndroidViewModel {
    @Inject
    SearchRepository searchRepository;
    public SearchViewModel(@NonNull Application application) {
        super(application);
       SearchComponet searchComponet= DaggerSearchComponet.builder().searchModule(new SearchModule()).build();
       searchComponet.inject(this);
    }
    public  LiveData<Search>getsearch(String  search){
        return searchRepository.getNews(search);
    }
}

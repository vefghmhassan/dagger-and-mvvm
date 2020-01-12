package com.vefgh.projecttest.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vefgh.projecttest.Models.Search;
import com.vefgh.projecttest.Server.Api;
import com.vefgh.projecttest.Server.ResponseData;
import com.vefgh.projecttest.Server.RetrofitSingleton;

import retrofit2.Response;

public class SearchRepository {
    public LiveData<Search> getNews(String searchText) {
        final MutableLiveData<Search> data = new MutableLiveData<>();
        RetrofitSingleton.getRetrofit().create(Api.class).getSearch(0, searchText, 0).enqueue(new ResponseData<Search>() {
            @Override
            protected void onResponse(Response<Search> response) {
                data.postValue(response.body());
            }
        });
        return data;
    }
}

package com.vefgh.projecttest.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vefgh.projecttest.Models.News;
import com.vefgh.projecttest.Server.Api;
import com.vefgh.projecttest.Server.ResponseData;
import com.vefgh.projecttest.Server.RetrofitSingleton;

import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsRepository {
    public LiveData<News> getNews() {
        final MutableLiveData<News> data = new MutableLiveData<>();
        RetrofitSingleton.getRetrofit().create(Api.class).getNews().enqueue(new ResponseData<News>() {
            @Override
            protected void onResponse(Response<News> response) {
                data.postValue(response.body());
            }
        });
        return data;
    }
}

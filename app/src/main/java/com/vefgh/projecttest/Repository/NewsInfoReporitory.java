package com.vefgh.projecttest.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vefgh.projecttest.Models.NewsInfo;
import com.vefgh.projecttest.Server.Api;
import com.vefgh.projecttest.Server.ResponseData;
import com.vefgh.projecttest.Server.RetrofitSingleton;


import retrofit2.Response;

public class NewsInfoReporitory {

    public LiveData<NewsInfo> getNewsInfo(int idNews) {
        final MutableLiveData<NewsInfo> data = new MutableLiveData<>();
        RetrofitSingleton.getRetrofit().create(Api.class).getNewsInfo(idNews, 0).enqueue(
                new ResponseData<NewsInfo>() {
                    @Override
                    protected void onResponse(Response<NewsInfo> response) {
                        data.postValue(response.body());
                    }
                }
        );
        return data;
    }
}

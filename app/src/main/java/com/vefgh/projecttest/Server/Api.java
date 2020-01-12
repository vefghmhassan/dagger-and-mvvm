package com.vefgh.projecttest.Server;

import com.vefgh.projecttest.Constants.Constant;
import com.vefgh.projecttest.Models.News;
import com.vefgh.projecttest.Models.NewsInfo;
import com.vefgh.projecttest.Models.Search;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @POST(Constant.getNewsInfo)
    @FormUrlEncoded
    Call<NewsInfo>getNewsInfo(@Field("newsId") int newsId, @Field("userId") int userId);

    @POST(Constant.getSearch)
    @FormUrlEncoded
    Call<Search>getSearch(@Field("stateId") int stateId, @Field("text") String text, @Field("page") int page);

    @POST(Constant.getNews)
    Call<News>getNews();
}

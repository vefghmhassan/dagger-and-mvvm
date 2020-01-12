package com.vefgh.projecttest.Server;



import com.vefgh.projecttest.Constants.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit instance;


    private RetrofitSingleton() {

    }

    public static Retrofit getRetrofit() {

        if (instance == null) {


            instance = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL + "api/v1/" )
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return instance;
    }
}

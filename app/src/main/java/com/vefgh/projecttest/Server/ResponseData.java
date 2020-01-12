package com.vefgh.projecttest.Server;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  abstract class ResponseData<TResponse> implements Callback<TResponse> {




    @Override
    public void onResponse(Call<TResponse> call, Response<TResponse> response) {
        if (response.code() == 401) {
        } else if (response.code() == 200) {
            if (response.body() != null) {
                onResponse(response);
            }
        }
    }

     protected abstract void onResponse(Response<TResponse> response) ;


    @Override
    public void onFailure(Call<TResponse> call, Throwable t) {

    }


}

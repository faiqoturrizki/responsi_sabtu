package com.example.jean.retrofitexample.service;

import com.example.jean.retrofitexample.player.RestResponse;
import com.example.jean.retrofitexample.model.RestResponseHistory;

import retrofit2.Call;
import retrofit2.http.GET;


public interface BaseAPI {

    @GET("player")
    Call<RestResponse> getPlayer();

    @GET("history")
    Call<RestResponseHistory> getHistory();

}

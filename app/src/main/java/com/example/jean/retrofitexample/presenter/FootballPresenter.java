package com.example.jean.retrofitexample.presenter;

import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.player.Player;
import com.example.jean.retrofitexample.player.RestResponse;
import com.example.jean.retrofitexample.model.RestResponseHistory;
import com.example.jean.retrofitexample.service.BaseService;
import com.example.jean.retrofitexample.view.FootballView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballPresenter {

    private FootballView footballView;
    private BaseService baseService;

    public FootballPresenter(FootballView view) {
        this.footballView = view;

        if (this.baseService == null) {
            this.baseService = new BaseService();
        }
    }

    public void getPlayerPresenter() {
        baseService
                .getAPI()
                .getPlayer()
                .enqueue(new Callback<RestResponse>() {
                    @Override
                    public void onResponse(Call<RestResponse> call, Response<RestResponse> response) {
                        RestResponse data = response.body();

                     if (response.isSuccessful()){
                         List<Player> result = data.getResult();
                     footballView.playerFootball(result);
                     }
                     }


                    @Override
                    public void onFailure(Call<RestResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void getHistory(){
        baseService.getAPI().getHistory().enqueue(new Callback<RestResponseHistory>() {
            @Override
            public void onResponse(Call<RestResponseHistory> call, Response<RestResponseHistory> response) {
                RestResponseHistory data = response.body();

                if (response.isSuccessful()){
                    List<History> result = data.getResult();
                    footballView.historyReady(result);
                }
            }

            @Override
            public void onFailure(Call<RestResponseHistory> call, Throwable t) {

            }
        });

    }
}

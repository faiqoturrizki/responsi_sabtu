package com.example.jean.retrofitexample.presenter;


import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.model.RestResponseHistory;
import com.example.jean.retrofitexample.service.BaseService;
import com.example.jean.retrofitexample.view.DetailView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    DetailView detailView;
    BaseService baseService;

    public DetailPresenter(DetailView detailView) {
        this.detailView = detailView;
        if (this.baseService==null){
            this.baseService = new BaseService();
        }
    }
    public void getHistory(){
        baseService.getAPI().getHistory().enqueue(new Callback<RestResponseHistory>() {
            @Override
            public void onResponse(Call<RestResponseHistory> call, Response<RestResponseHistory> response) {
                if (response.isSuccessful()){
                    RestResponseHistory data= response.body();
                    List<History> histories = data.getResult();
                    detailView.updateDetail(histories);
                }
            }

            @Override
            public void onFailure(Call<RestResponseHistory> call, Throwable t) {

            }
        });
    }
}

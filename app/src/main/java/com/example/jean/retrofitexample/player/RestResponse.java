package com.example.jean.retrofitexample.player;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse {

    @SerializedName("success")
    private Boolean messages;

    @SerializedName("data")
    private List<Player> result;

    public List<Player> getResult() {
        return result;
    }

    public Boolean getMessages() {
        return messages;
    }
}
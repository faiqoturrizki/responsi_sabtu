package com.example.jean.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponseHistory {

    @SerializedName("success")
    private Boolean messages;

    @SerializedName("data")
    private List<History> result;

    public List<History> getResult() {
        return result;
    }

    public Boolean getMessages() {
        return messages;
    }
}
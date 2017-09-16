package com.example.fernandocisneros.fakeinstagram.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public class Data {

    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}

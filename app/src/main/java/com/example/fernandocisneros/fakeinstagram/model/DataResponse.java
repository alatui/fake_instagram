package com.example.fernandocisneros.fakeinstagram.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by fernandocisneros on 16/09/2017.
 */

public class DataResponse {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Item> getItems() {
        return this.data.getResult().getItems();
    }

}

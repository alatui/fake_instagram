package com.example.fernandocisneros.fakeinstagram.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public class Result {

    @SerializedName("items")
    @Expose
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}

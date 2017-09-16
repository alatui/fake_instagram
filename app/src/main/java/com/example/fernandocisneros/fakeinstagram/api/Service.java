package com.example.fernandocisneros.fakeinstagram.api;

import com.example.fernandocisneros.fakeinstagram.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public interface Service {


    @GET("/api/search/images?count=20&offset=1&q=cars")
    Call<ItemResponse> getItems();

}

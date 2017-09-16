package com.example.fernandocisneros.fakeinstagram.api;

import com.example.fernandocisneros.fakeinstagram.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public interface Service {


    @GET("/api/search/images?count=60&offset=1&q=cars")
    Call<DataResponse> getItems();

}

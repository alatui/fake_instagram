package com.example.fernandocisneros.fakeinstagram.controller;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernandocisneros.fakeinstagram.R;
import com.example.fernandocisneros.fakeinstagram.api.Client;
import com.example.fernandocisneros.fakeinstagram.api.Service;
import com.example.fernandocisneros.fakeinstagram.model.DataResponse;
import com.example.fernandocisneros.fakeinstagram.model.Item;
import com.example.fernandocisneros.fakeinstagram.ItemAdapter;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    TextView Disconected;
    private Item item;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(MainActivity.this, "Images refreshed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching...");
        pd.setCancelable(false);
        pd.show();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON() {
        Disconected = (TextView) findViewById(R.id.disconnected);
        try {
            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Call<DataResponse> call = apiService.getItems();
            call.enqueue(new Callback<DataResponse>() {
                @Override
                public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                    List<Item> items = response.body().getItems();
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                    swipeContainer.setRefreshing(false);
                    pd.hide();
                }

                @Override
                public void onFailure(Call<DataResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error fetching data!", Toast.LENGTH_SHORT).show();
                    Disconected.setVisibility(View.VISIBLE);
                    pd.hide();
                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            pd.hide();
        }
    }


}

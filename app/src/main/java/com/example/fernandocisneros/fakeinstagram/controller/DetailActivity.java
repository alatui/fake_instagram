package com.example.fernandocisneros.fakeinstagram.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.fernandocisneros.fakeinstagram.R;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imageView = (ImageView) findViewById(R.id.instagram_image);

        String instagram_image = getIntent().getExtras().getString("instagram_image");

        Glide.with(this)
                .load(instagram_image)
                .placeholder(R.drawable.load3)
                .centerCrop()
                .into(imageView);

        getSupportActionBar().setTitle("Image preview");

    }

    private Intent createShareForcastIntent() {
        String link = getIntent().getExtras().getString("instagram_image");
        Intent share = ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain").setText("Check out this image: " + link)
                .getIntent();
        return share;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForcastIntent());
        return true;
    }

}

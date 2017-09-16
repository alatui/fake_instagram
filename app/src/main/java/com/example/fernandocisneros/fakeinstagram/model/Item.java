package com.example.fernandocisneros.fakeinstagram.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fernandocisneros on 16/09/2017.
 */

public class Item {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("media")
    @Expose
    private String media;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("media_fullsize")
    @Expose
    private String media_fullsize;

    public Item(String title, String media, String thumbnail, String media_fullsize) {
        this.title = title;
        this.media = media;
        this.thumbnail = thumbnail;
        this.media_fullsize = media_fullsize;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia() {
        return media;
    }
    public void setMedia(String media) {
        this.media = media;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMedia_fullsize() {
        return media_fullsize;
    }
    public void setMedia_fullsize(String media_fullsize) {
        this.media_fullsize = media_fullsize;
    }

/*
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    public Item(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }


    public String getAvatar_url() {
        return avatar_url;
    }
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
*/


}

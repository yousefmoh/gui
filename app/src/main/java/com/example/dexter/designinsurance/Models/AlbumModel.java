package com.example.dexter.designinsurance.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dexter on 4/2/2018.
 */

public class AlbumModel {

    @SerializedName("image_url")
    String ImageUrl;
    @SerializedName("title")
    String Name;
    @SerializedName("id")
    String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

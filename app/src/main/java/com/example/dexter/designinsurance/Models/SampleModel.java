package com.example.dexter.designinsurance.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dexter on 4/14/2018.
 */

public class SampleModel {
    private ArrayList<albums> albums;

    public ArrayList<SampleModel.albums> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<SampleModel.albums> albums) {
        this.albums = albums;
    }

    public  class  images {
        String image;

       // String id;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }


    }
    public class albums {


        @SerializedName("title")
        private String title;

        @SerializedName("id")
        private  String id;

        @SerializedName("image_url")
        private  String ImageUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @SerializedName("album_images")
        private List<images> Images ;

        public List<images> getImages() {
            return Images;
        }

        public void setImages(List<images> images) {
            Images = images;
        }



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




    }
}

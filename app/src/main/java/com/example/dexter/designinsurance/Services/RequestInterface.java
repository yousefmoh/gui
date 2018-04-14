package com.example.dexter.designinsurance.Services;

import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.Models.Images;
import com.example.dexter.designinsurance.Models.InsurancePackagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dexter on 2/17/2018.
 */

public interface RequestInterface {



    @GET("insuranceapis/packages.php")//http://snap-project.com/insuranceapis/packages.php
    Call<List<InsurancePackagesModel>> GetPackages() ;

    @GET("insuranceapis/albums.php")//http://snap-project.com/insuranceapis/albums.php
    Call<List<AlbumModel>> GetAlbums() ;



    @GET("insuranceapis/imgablums.php")//http://snap-project.com/insuranceapis/albums.php

    Call<JSONResponse> GetAlbumss();

    @GET("/insuranceapis/images.php/{id}")//insuranceapis/images.php?id=1
    Call<List<Images>> getImages(@Query("id") int id);



}

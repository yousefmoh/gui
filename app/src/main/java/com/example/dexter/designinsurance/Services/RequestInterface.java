package com.example.dexter.designinsurance.Services;

import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.Models.Images;
import com.example.dexter.designinsurance.Models.InsurancePackagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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


    @FormUrlEncoded
    @POST("/insuranceapis/insert.php")
    Call<String> insertData( @Field("name") String name,@Field("age") int age);



    @FormUrlEncoded
    @POST("/insuranceapis/insertuser.php")
    Call<String> insertUser( @Field("username") String username,
                             @Field("international_Id") String international_Id,
                             @Field("mobilenumber") String mobilenumber,
                             @Field("branchnumber") String branchnumber,
                             @Field("insurancetype") String insurancetype,
                             @Field("paymethod") String paymethod,
                             @Field("accountnumber") String accountnumber);

//username,international_Id, mobilenumber,branchnumber,insurancetype,paymethod,accountnumber



}

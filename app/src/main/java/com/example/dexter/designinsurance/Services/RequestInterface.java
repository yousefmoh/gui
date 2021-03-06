package com.example.dexter.designinsurance.Services;

import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.Models.Images;
import com.example.dexter.designinsurance.Models.InsurancePackagesModel;
import com.example.dexter.designinsurance.Models.ResponseModel;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
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
                             @Field("email") String email,
                             @Field("branchnumber") String branchnumber,
                             @Field("insurancetype") String insurancetype,
                             @Field("paymethod") String paymethod,
                             @Field("accountnumber") String accountnumber,
                             @Field("idpath") String Idpath,
                             @Field("driveicencepath") String driveLicencePath,
                             @Field("carlicencepath") String carlicencepath


    );




    @FormUrlEncoded
    @POST("/insuranceapis/insertfeedback.php")
    Call<String> insertFeedback( @Field("feedback") String Feedback

    );
//username,international_Id, mobilenumber,branchnumber,insurancetype,paymethod,accountnumber


    @Multipart
    @POST("/insuranceapis/uploadfile.php")
    Call<String> upload(
            @PartMap Map<String, RequestBody> map
    );

   @Multipart
    @POST("/insuranceapis/uploadfile.php")
    Call<ResponseModel> uploadFile(
            @PartMap Map<String, RequestBody> map
    );



}

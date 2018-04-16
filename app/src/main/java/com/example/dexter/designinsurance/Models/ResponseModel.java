package com.example.dexter.designinsurance.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dexter on 4/16/2018.
 */

public class ResponseModel {

    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

}

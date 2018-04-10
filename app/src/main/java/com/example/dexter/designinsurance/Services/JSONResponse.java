package com.example.dexter.designinsurance.Services;


import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.Models.InsurancePackagesModel;

/**
 * Created by Dexter on 2/17/2018.
 */

public class JSONResponse {


    private InsurancePackagesModel[] packages;

    public InsurancePackagesModel[] getPackages() {
        return packages;
    }

    public void setPackages(InsurancePackagesModel[] packages) {
        this.packages = packages;
    }
}

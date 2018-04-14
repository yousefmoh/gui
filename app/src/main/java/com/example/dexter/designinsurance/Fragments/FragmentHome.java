package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentHome extends Fragment  implements View.OnClickListener {
    View view;
    ImageView aboutus,album,insurancePackage,callUs,emergancyNumbers,help,report,locations,emp;
    Fragment fragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.home_fragment, container, false);
        setItems();

        return view;
    }

    public  void  setItems()
    {

        insurancePackage=(ImageView) view.findViewById(R.id.insurance_packageImg);
        aboutus=(ImageView) view.findViewById(R.id.aboutusImage);
        album=(ImageView) view.findViewById(R.id.albumImg);
        help=(ImageView) view.findViewById(R.id.helpBtn);
        insurancePackage.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        album.setOnClickListener(this);
        help.setOnClickListener(this);

    }


    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.insurance_packageImg:
                fragment=new FragmentInsurancePackage();
                break;
            case R.id.aboutusImage:
                fragment=new FragmentAboutUs();
                break;
                case R.id.albumImg:
                fragment=new FragmentAlbum();
                break;

                case R.id.helpBtn:
                fragment=new FragmentHelp();
                break;
        }
        OpenFragment();
    }





    public  void  OpenFragment()
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }







}

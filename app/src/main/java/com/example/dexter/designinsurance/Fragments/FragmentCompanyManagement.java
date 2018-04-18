package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dexter on 4/13/2018.
 */

public class FragmentCompanyManagement extends Fragment {
    View view;
    Toolbar toolbar;
    ImageView directorimgId1,directorimgId2,directorimgId3,directorimgId4;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.frg_mgmt_sh_companymanagement, container, false);
        directorimgId1=(ImageView)view.findViewById(R.id.directorimgId1);
        directorimgId2=(ImageView)view.findViewById(R.id.directorimgId2);
        directorimgId3=(ImageView)view.findViewById(R.id.directorimgId3);
        directorimgId4=(ImageView)view.findViewById(R.id.directorimgId4);
        Picasso.with(getActivity()).load("http://gui.ps/plugins/kcfinder/upload/albums/x2.jpg").into(directorimgId1);
        Picasso.with(getActivity()).load("http://gui.ps/plugins/kcfinder/upload/albums/x1.jpg").into(directorimgId2);
        Picasso.with(getActivity()).load("http://gui.ps/plugins/kcfinder/upload/albums/x4.jpg").into(directorimgId3);
        Picasso.with(getActivity()).load("http://gui.ps/plugins/kcfinder/upload/albums/x3.jpg").into(directorimgId4);


        InitToolbar();

        return view;
    }


    public  void  InitToolbar()
    {

        toolbar=(Toolbar)view.findViewById(R.id.custom_toolbar) ;
        // titlebar=(TextView)view.findViewById(R.id.titlebar);
        // titlebar.setText("My title");
        // toolbar.setTitle("aaaa");

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
               // Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.GallaryActivity;
import com.example.dexter.designinsurance.InsuranceRequestActivity;
import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.TypefaceUtil;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentHome extends Fragment  implements View.OnClickListener {
    View view;
    ImageView aboutus,album,insurancePackage,contact_us,emergancyNumbers,help,report,locations,insurancerequest;
    Fragment fragment;
    TextView testText;
    TextView whoweare,text2,text3,text4,text5;


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

        setTextItems();
        //Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/test2.ttf");
        //testText.setTypeface(type);

        return view;
    }

    public  void  setItems()
    {

        insurancePackage=(ImageView) view.findViewById(R.id.insurance_packageImg);
        aboutus=(ImageView) view.findViewById(R.id.aboutusImage);
        album=(ImageView) view.findViewById(R.id.albumImg);
        help=(ImageView) view.findViewById(R.id.helpBtn);
        insurancerequest=(ImageView) view.findViewById(R.id.insurancerequestId);
        contact_us=(ImageView) view.findViewById(R.id.contact_usId);
        report=(ImageView) view.findViewById(R.id.repoortId);


        insurancePackage.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        album.setOnClickListener(this);
        help.setOnClickListener(this);
        insurancerequest.setOnClickListener(this);
        report.setOnClickListener(this);

    }

    public  void setTextItems()
    {
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/oredoo.ttf");

        testText=(TextView)view.findViewById(R.id.testText);
        whoweare=(TextView)view.findViewById(R.id.whoweare);
        text2=(TextView)view.findViewById(R.id.text2);
        text3=(TextView)view.findViewById(R.id.text3);
        text4=(TextView)view.findViewById(R.id.text4);
        text5=(TextView)view.findViewById(R.id.text5);

        testText.setTypeface(type);
        whoweare.setTypeface(type);
        text2.setTypeface(type);
        text3.setTypeface(type);
        text4.setTypeface(type);
        text5.setTypeface(type);





    }

    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.insurance_packageImg:
                fragment=new FragmentInsurancePackage();
                OpenFragment();
                break;
            case R.id.aboutusImage:
                fragment=new FragmentAboutUs();
                OpenFragment();
                break;
                case R.id.albumImg:
                fragment=new FragmentAlbum();
                    OpenFragment();
                break;
           case R.id.contact_usId:
                fragment=new ContactUsFragment();
                    OpenFragment();
                break;

                case R.id.helpBtn:
                fragment=new FragmentHelp();
                    OpenFragment();
                break;
            case R.id.repoortId:
                fragment=new ReportFragment();
                OpenFragment();
                break;
                case R.id.insurancerequestId:
                    Intent intent = new Intent(getActivity(),InsuranceRequestActivity.class);
                    startActivity(intent);
                break;
        }
        //OpenFragment();
    }





    public  void  OpenFragment()
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }







}

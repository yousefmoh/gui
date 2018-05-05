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
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;

/**
 * Created by dexter on 3/31/2018.
 */

public class InsuranceInformationFragment extends Fragment  {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    TextView content;
    TextView insuranceTitle,insuranceSubTitle,insuranceInfo,insuranceInfo2,insuranceInfo3;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.insurance_information_fragment, container, false);
        insuranceTitle=(TextView)view.findViewById(R.id.insuranceTitle);
        insuranceSubTitle=(TextView)view.findViewById(R.id.insuranceSubTitle);
        insuranceInfo=(TextView)view.findViewById(R.id.insuranceInfo);
        insuranceInfo2=(TextView)view.findViewById(R.id.insuranceInfo2);
        insuranceInfo3=(TextView)view.findViewById(R.id.insuranceInfo3);

        setContent();


      //  content=(TextView)view.findViewById((R.id.contentId));
        InitToolbar();
       // setContent();
        return view;
    }



    public void setContent()
     {   int  Position=Flags.Positionflag;
         switch(Position) {
             case 0:

                 Toast.makeText(this.getActivity(),Position+"",Toast.LENGTH_SHORT).show();
              //   content.setText(R.string.our_messagetext);
                 break;

             case 1:
                 insuranceSubTitle.setText(R.string.MarineInsuranceSubTitle);
                 insuranceInfo.setText(R.string.MarineInsurance);
                 insuranceInfo2.setText("");
                 insuranceInfo3.setText("");

                 insuranceTitle.setText(R.string.MarineInsuranceTitle);
                 Toast.makeText(this.getActivity(),Position+"",Toast.LENGTH_SHORT).show();
                 // content.setText(R.string.about_international);
                 break;
             case 2:
                 Toast.makeText(this.getActivity(),Position+"",Toast.LENGTH_SHORT).show();
                 // content.setText(R.string.about_international);
                 break;
             case 3:
                 Toast.makeText(this.getActivity(),Position+"",Toast.LENGTH_SHORT).show();
                 // content.setText(R.string.about_international);
                 break;
             case 4:
                 Toast.makeText(this.getActivity(),Position+"",Toast.LENGTH_SHORT).show();
                 // content.setText(R.string.about_international);
                 break;
             case 5:
                 Toast.makeText(this.getActivity(),Position+"",Toast.LENGTH_SHORT).show();
                 // content.setText(R.string.about_international);
                 break;
         }
     }


    public  void  InitToolbar()
    {

        toolbar=(Toolbar)view.findViewById(R.id.custom_toolbar) ;

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
              //  Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

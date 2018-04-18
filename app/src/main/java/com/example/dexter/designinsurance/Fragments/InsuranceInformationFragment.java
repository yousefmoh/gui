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



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.insurance_information_fragment, container, false);
      //  content=(TextView)view.findViewById((R.id.contentId));
        InitToolbar();
       // setContent();
        return view;
    }



    public void setContent()
     {   String FragmentName=Flags.fragmentname;
         switch(FragmentName) {
             case "OurMessage":
                 content.setText(R.string.our_messagetext);
                 break;
                 case "OurVision":
                 content.setText(R.string.our_vision_text);
                 break;
             case "AboutGlobal":
                 content.setText(R.string.about_international);
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

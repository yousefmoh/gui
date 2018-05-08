package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.VideoActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentHelp extends Fragment  implements View.OnClickListener{
    View view;
    Fragment fragment;
    Toolbar toolbar;
    Button helpVideobtn,commonQuestionBtn,cancelInsuranceBtn,ShareHoldersBtn;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.help_fragment, container, false);
        InitToolbar();
        SetItems();
        return view;
    }
    public  void  SetItems()
    {

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/oredoo.ttf");


        helpVideobtn=(Button) view.findViewById(R.id.helpVideoId);
        commonQuestionBtn=(Button) view.findViewById(R.id.commonQuestionId);
        cancelInsuranceBtn=(Button) view.findViewById(R.id.cancelInsuranceId);
        helpVideobtn.setOnClickListener(this);
        commonQuestionBtn.setOnClickListener(this);
        cancelInsuranceBtn.setOnClickListener(this);

        helpVideobtn.setTypeface(type);
        cancelInsuranceBtn.setTypeface(type);
        commonQuestionBtn.setTypeface(type);

    }



   /* public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.ourmessageId:
                fragment=new FragmentOurMessage();
                break;
            case R.id.aboutourcompanyId:
                fragment=new FragmentAboutGlobal();
                break;
            case R.id.ourshareholdersId:
                fragment=new FragmentMangmentShareholders();
                break;
                case R.id.ourvisionId:
                fragment=new FragmentOurVision();
                break;
        }
        OpenFragment();
    }
*/



   public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.helpVideoId:
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                startActivity(intent);
                break;

            case R.id.commonQuestionId:
               fragment=new CommonQuestionsFragment();
               OpenFragment();
                break;
            case R.id.cancelInsuranceId:
                fragment=new CancelInsuranceFragment();
                OpenFragment();
                break;


        }
       // OpenFragment();
    }


    public  void  OpenFragment()
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
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
                //Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }









}

package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentAboutUs extends Fragment  implements View.OnClickListener{
    View view;
    Fragment fragment;
    Toolbar toolbar;
    Button OurMessageBtn,OurVisionBtn,AboutUsBtn,ShareHoldersBtn;
    TextView title;
    Typeface type;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.about_us_fragment, container, false);
        type  = Typeface.createFromAsset(getActivity().getAssets(),"fonts/oredoo.ttf");
        title=(TextView)view.findViewById(R.id.title);
        title.setTypeface(type);

        fragment=new InformationFragment();

        InitToolbar();
        SetItems();
        return view;
    }
    public  void  SetItems()
    {


        OurMessageBtn=(Button) view.findViewById(R.id.ourmessageId);
        OurVisionBtn=(Button) view.findViewById(R.id.ourvisionId);
        AboutUsBtn=(Button) view.findViewById(R.id.aboutourcompanyId);
        ShareHoldersBtn=(Button) view.findViewById(R.id.ourshareholdersId);

        OurMessageBtn.setOnClickListener(this);
        OurVisionBtn.setOnClickListener(this);
        ShareHoldersBtn.setOnClickListener(this);
        AboutUsBtn.setOnClickListener(this);


        OurMessageBtn.setTypeface(type);
        OurVisionBtn.setTypeface(type);
        AboutUsBtn.setTypeface(type);
        ShareHoldersBtn.setTypeface(type);


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
            case R.id.ourmessageId:
                Flags.fragmentname="OurMessage";
                break;

            case R.id.ourvisionId:
                Flags.fragmentname="OurVision";
                break;
            case R.id.aboutourcompanyId:
                Flags.fragmentname="AboutGlobal";
                break;
            case R.id.ourshareholdersId:
                fragment=new FragmentMangmentShareholders();
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
                getFragmentManager().popBackStack();

                //Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }









}

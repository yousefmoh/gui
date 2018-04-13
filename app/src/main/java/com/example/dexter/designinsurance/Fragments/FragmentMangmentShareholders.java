package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentMangmentShareholders extends Fragment implements  View.OnClickListener {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    Button ExecutionDirectorsBtn;
    Button CompanyManagementId,BoardofDirectorsId,SeniorshareholdersId,ExecutiveManagementId;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.mangment_shareholders, container, false);
        SetItems();
        InitToolbar();
        return view;
    }


    public  void  SetItems()
    {


        CompanyManagementId=(Button) view.findViewById(R.id.CompanyManagementId);
        BoardofDirectorsId=(Button) view.findViewById(R.id.BoardofDirectorsId);
        ExecutiveManagementId=(Button) view.findViewById(R.id.ExecutiveManagementId);
        SeniorshareholdersId=(Button) view.findViewById(R.id.SeniorshareholdersId);

        CompanyManagementId.setOnClickListener(this);
        BoardofDirectorsId.setOnClickListener(this);
        ExecutiveManagementId.setOnClickListener(this);
        SeniorshareholdersId.setOnClickListener(this);
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
                Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.CompanyManagementId:
                fragment=new FragmentCompanyManagement();

                break;

            case R.id.BoardofDirectorsId:
                fragment=new FragmentBoardsDirectors();

                break;

            case R.id.ExecutiveManagementId:
                fragment=new FragmentExecutionDirectors();
                break;
            case R.id.SeniorshareholdersId:
                fragment=new FragmentSeniorShareholders();

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

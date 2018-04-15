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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;

/**
 * Created by dexter on 3/31/2018.
 */

public class RequestTowFragment extends Fragment  {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    TextView content;
    Button nextIdBtn;

    int test=0;
    String Name,ID,MobileNumber;
    EditText payMethod,insuarnceType,accountNumber,partionNumber;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.request_tow_fragment, container, false);
        Bundle bundle = this.getArguments();
        Name=bundle.getString("name");
        ID=bundle.getString("ID");
        MobileNumber=bundle.getString("numb");
        InitItems();


        nextIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (partionNumber.getText().toString().isEmpty()
                        ||insuarnceType.getText().toString().isEmpty()
                    ||payMethod.getText().toString().isEmpty()
                        ||accountNumber.getText().toString().isEmpty())
                {

                    Toast.makeText(getActivity(),"Plase Make sure that you insert all data! Thanks ",Toast.LENGTH_SHORT).show();
                    return;


                }

                PassData();


            }
        });
        InitToolbar();
        return view;
    }
    private  void  InitItems()
    {   nextIdBtn=(Button)view.findViewById(R.id.nextIdBtn);
        partionNumber=(EditText)view.findViewById(R.id.partionNumber);
        insuarnceType=(EditText)view.findViewById(R.id.insuranceType);
        payMethod=(EditText)view.findViewById(R.id.payMethodId);
        accountNumber=(EditText)view.findViewById(R.id.accountNumber);
    }




    private void  PassData()
    {
        Bundle bundle=new Bundle();
        bundle.putString("name", Name);
        bundle.putString("numb", MobileNumber);
        bundle.putString("ID",ID);
        bundle.putString("partionNumber", partionNumber.getText()+"");
        bundle.putString("insuarnceType", insuarnceType.getText()+"");
        bundle.putString("accountNumber",accountNumber.getText()+"");
        bundle.putString("payMethod",payMethod.getText()+"");
        fragment=new RequestThreeFragment();
        fragment.setArguments(bundle);
        OpenFragment();
    }
    private  void  OpenFragment()
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
                Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

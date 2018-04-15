package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.Services.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dexter on 3/31/2018.
 */

public class RequestThreeFragment extends Fragment  {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    TextView content;
    Button nextIdBtn;


    String name,numb,Id,branchNumber,insuarnceType,accountNumber,payMethod;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.request_three_fragment, container, false);
        Bundle bundle = this.getArguments();
        name=bundle.getString("name");
        numb=bundle.getString("numb");
        Id=bundle.getString("ID");
        branchNumber=bundle.getString("partionNumber");
        insuarnceType=bundle.getString("insuarnceType");
        accountNumber=bundle.getString("accountNumber");
        payMethod=bundle.getString("payMethod");
        nextIdBtn=(Button)view.findViewById(R.id.nextIdBtn);

        nextIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUser();


            }
        });
        Toast.makeText(getActivity(),name+numb+Id+branchNumber+insuarnceType+accountNumber+payMethod,Toast.LENGTH_SHORT).show();

        return view;
    }





    private  void   insertUser()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);
        Call<String> call = request.insertUser(name,Id,numb,branchNumber,insuarnceType,payMethod,accountNumber);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getActivity(),response.body(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),response+"",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ee",t.getMessage());

            }
        });



    }


/*
 bundle.putString("name", Name);
        bundle.putString("numb", MobileNumber);
        bundle.putString("ID",ID);
        bundle.putString("partionNumber", partionNumber.getText()+"");
        bundle.putString("insuarnceType", insuarnceType.getText()+"");
        bundle.putString("accountNumber",accountNumber.getText()+"");
        bundle.putString("payMethod",payMethod.getText()+"");
 */

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

package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.content.Context;
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
import com.obsez.android.lib.filechooser.ChooserDialog;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
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
    int flag=0;
    String _path;
    String FilePath="";
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
                //insertUser();
               Toast.makeText(getActivity(),FilePath,Toast.LENGTH_SHORT).show();
               if (flag==1)

               {
                   uploadfile(FilePath);
                   return;
               }

                new ChooserDialog().with(getActivity())
                        .withFilter(false, false, "jpg", "jpeg", "png")
                        .withStartFile(_path)
                        .withResources(R.string.title_choose, R.string.title_choose, R.string.dialog_cancel)
                        .withChosenListener(new ChooserDialog.Result() {
                            @Override
                            public void onChoosePath(String path, File pathFile) {
                               // uploadfile(path);
                                flag=1;
                                FilePath=path;
                            }
                        })
                        .build()
                        .show();
               // Toast.makeText(getActivity(), "FILE: " + _path, Toast.LENGTH_SHORT).show();

              //  uploadfile();
            }
        });

        Toast.makeText(getActivity(),name+numb+Id+branchNumber+insuarnceType+accountNumber+payMethod,Toast.LENGTH_SHORT).show();

        return view;
    }



    private void  uploadfile(String path)
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();

        Map<String, RequestBody> map = new HashMap<>();
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<String> call = request.upload(map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getActivity(), response.body()+"",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage()+"",Toast.LENGTH_SHORT).show();

            }
        });





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

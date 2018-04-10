package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dexter.designinsurance.Adapters.InsurancePackageAdapter;
import com.example.dexter.designinsurance.Models.InsurancePackagesModel;
import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.Services.JSONResponse;
import com.example.dexter.designinsurance.Services.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentInsurancePackage extends Fragment {
    View view;
    RecyclerView recyclerView;
    InsurancePackageAdapter adapter;
    Context context;
    ArrayList<InsurancePackagesModel> data=new ArrayList<>();
    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_insurancepackage, container, false);

        setHasOptionsMenu(true);
        InitToolbar();
        loadJSON();
      //  setRecycleView();
        return view;
    }


    public  void InitToolbar()
    {
        recyclerView=(RecyclerView)view.findViewById(R.id.card_recycler_view);
        toolbar=(Toolbar)view.findViewById(R.id.custom_toolbar) ;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);


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

    void setRecycleView(){


       adapter = new InsurancePackageAdapter(getActivity(),data);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void loadJSON( ){
        //progressDialog.show(); // Display Progress Dialog


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<List<InsurancePackagesModel>> call = request.GetPackages();
        call.enqueue(new Callback<List<InsurancePackagesModel>>() {
            @Override
            public void onResponse(Call<List<InsurancePackagesModel>> call, Response<List<InsurancePackagesModel>> response) {
                List<InsurancePackagesModel> jsonResponse = response.body();
                data = new ArrayList<>(jsonResponse);
                setRecycleView();

            }

            @Override
            public void onFailure(Call<List<InsurancePackagesModel>> call, Throwable t) {

            }
        });
    /*    call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();


                data = new ArrayList<>(Arrays.asList(jsonResponse.getPackages()));

                setRecycleView();
               // adapter = new InsurancePackageAdapter(getActivity(),data);

                //recyclerView.setAdapter(adapter);
            }



            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage()+"",Toast.LENGTH_SHORT).show();

                Log.d("Error",t.getMessage());
            }
        });
*/

    }

}

package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.content.Context;
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
import android.widget.Toast;

import com.example.dexter.designinsurance.Models.Images;
import com.example.dexter.designinsurance.PicassoImageLoader;
import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.Services.RequestInterface;
import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentImages extends Fragment {
    View view;
    Context context;
    ArrayList<Images> data=new ArrayList<>();
    Toolbar toolbar;
    List<MediaInfo> infos;
    private ArrayList<String> Images;
    private ScrollGalleryView scrollGalleryView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.gallary_layout, container, false);

        setHasOptionsMenu(true);

        loadJSON();
        infos = new ArrayList<>(Images.size());//
        for (String url : Images) infos.add(MediaInfo.mediaLoader(new PicassoImageLoader(url)));
        return view;
    }




    public  void InitToolbar()
    {
        toolbar=(Toolbar)view.findViewById(R.id.custom_toolbar) ;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);


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



    private void loadJSON( ){
        //progressDialog.show(); // Display Progress Dialog


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);

       Call<List<Images>> call = request.getImages(1);
        call.enqueue(new Callback<List<Images>>() {
            @Override
            public void onResponse(Call<List<Images>> call, Response<List<Images>> response) {
                List<Images> jsonResponse = response.body();
                data = new ArrayList<>(jsonResponse);
               // setRecycleView();

            }

            @Override
            public void onFailure(Call<List<Images>> call, Throwable t) {
         //Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }

}

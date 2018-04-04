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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dexter.designinsurance.Adapters.AlbumAdapter;
import com.example.dexter.designinsurance.Adapters.InsurancePackageAdapter;
import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.Models.InsuranceModel;
import com.example.dexter.designinsurance.R;

import java.util.ArrayList;

/**
 * Created by dexter on 3/31/2018.
 */

public class FragmentAlbum extends Fragment {
    View view;
    RecyclerView recyclerView;
    AlbumAdapter adapter;
    Context context;
    ArrayList<AlbumModel> data=new ArrayList<>();
    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_album, container, false);

        setHasOptionsMenu(true);
        InitToolbar();
        setRecycleView();
        return view;
    }


    public  void InitToolbar()
    {
        recyclerView=(RecyclerView)view.findViewById(R.id.album_recycler_view);
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
        for (int i=0;i<10;i++){
        AlbumModel model=new AlbumModel();
        if (i==0) {
            model.setName("بورصة فلسطين");
            model.setImageUrl("http://gui.ps/plugins/kcfinder/upload/albums/14_65.jpg");
        }
        else if( i==1){
            model.setName("الشركة العالمية المتحدة للتأمين");
            model.setImageUrl("http://gui.ps/plugins/kcfinder/upload/albums/10_42.jpg");
        }
        else {
            model.setName("بورصة فلسطين");
            model.setImageUrl("http://gui.ps/plugins/kcfinder/upload/albums/14_65.jpg");

        }
        data.add(model);
        }

        adapter = new AlbumAdapter(getActivity(),data);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}

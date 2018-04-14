package com.example.dexter.designinsurance.Adapters;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dexter.designinsurance.Fragments.InsuranceInformationFragment;
import com.example.dexter.designinsurance.Models.InsurancePackagesModel;
import com.example.dexter.designinsurance.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Dexter on 2/17/2018.
 */

public class InsurancePackageAdapter extends RecyclerView.Adapter<InsurancePackageAdapter.ViewHolder> {
     private Context context;
     private ArrayList<InsurancePackagesModel> data;
     private Fragment fragment;

    public InsurancePackageAdapter(Context context, ArrayList<InsurancePackagesModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insurance_card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          holder.name.setText(data.get(position).getName());
          Picasso.with(context).load(data.get(position).getImageUrl()).into(holder.imageView);
          holder.insurance_card_view.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                fragment=new InsuranceInformationFragment();
                  OpenFragment();
              }
          });
    }


    @Override
    public int getItemCount() {
        return data.size();

    }

    public  void  OpenFragment()
    {
        FragmentTransaction transaction =  ((Activity) context).getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public class ViewHolder   extends RecyclerView.ViewHolder{
        TextView name;
        ImageView imageView;
        CardView insurance_card_view;

        public ViewHolder(View view) {

            super(view);
            name=(TextView)view.findViewById(R.id.name);
            insurance_card_view=(CardView)view.findViewById(R.id.insurance_card_view);
            imageView=(ImageView)view.findViewById(R.id.image);


        }
    }

}



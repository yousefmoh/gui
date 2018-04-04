package com.example.dexter.designinsurance.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Dexter on 2/17/2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
     private Context context;
     private ArrayList<AlbumModel> data;

    public AlbumAdapter(Context context, ArrayList<AlbumModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          holder.name.setText(data.get(position).getName());
          Picasso.with(context).load(data.get(position).getImageUrl()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return data.size();

    }


    public class ViewHolder   extends RecyclerView.ViewHolder{
        TextView name;
        ImageView imageView;

        public ViewHolder(View view) {

            super(view);
            name=(TextView)view.findViewById(R.id.name);
            imageView=(ImageView)view.findViewById(R.id.image);


        }
    }

}



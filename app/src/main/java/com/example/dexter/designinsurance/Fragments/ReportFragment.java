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
import android.widget.EditText;
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

public class ReportFragment extends Fragment  {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    TextView content;
    EditText saywhatyouwant;
    Button Send;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.say_word_fragment, container, false);
        Send=(Button)view.findViewById(R.id.sendBtn);
        saywhatyouwant=(EditText)view.findViewById(R.id.saywhatyouwant) ;

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saywhatyouwant.getText().toString().isEmpty())
                {
                    Toast.makeText(view.getContext(),"الرجاء تعبئة الحقل !",Toast.LENGTH_SHORT).show();
                    return;
                }
                insertFeedBack();

            }
        });
        InitToolbar();
        return view;
    }




    private  void   insertFeedBack()
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
        Call<String> call = request.insertFeedback(saywhatyouwant.getText().toString());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Toast.makeText(getActivity(),"Success",Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ee",t.getMessage());

                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });



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
             //   Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

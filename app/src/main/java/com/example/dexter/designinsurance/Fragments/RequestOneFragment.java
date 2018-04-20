package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
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

import com.example.dexter.designinsurance.Models.AlbumModel;
import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.Services.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dexter on 3/31/2018.
 */

public class RequestOneFragment extends Fragment  {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    TextView content;
    EditText name,numb,Id,email;
    Button nextIdBtn;
    TextView oneText;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.request_one_fragment, container, false);
        nextIdBtn=(Button)view.findViewById(R.id.nextIdBtn);
        name=(EditText)view.findViewById(R.id.nameEditId);
        numb=(EditText)view.findViewById(R.id.mobileNumberEdit);
        Id=(EditText)view.findViewById(R.id.internationlIdEdit);
        email=(EditText)view.findViewById(R.id.email);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        nextIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty()||numb.getText().toString().isEmpty()||Id.getText().toString().isEmpty()||email.getText().toString().isEmpty())
                {
                      Toast.makeText(getActivity(),"Please Make sure that you insert all data! Thanks ",Toast.LENGTH_SHORT).show();
                      return;

                }
                if(!isEmailValid(email.getText().toString()))
                {
                    Toast.makeText(getActivity(),"Please Make sure that you write an valid email! Thanks ",Toast.LENGTH_SHORT).show();
                     return;
                }


                PassData();


            }
        });
        /*oneText=(TextView)view.findViewById(R.id.oneText);
        oneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("message", "Its Ok");
                fragment=new RequestTowFragment();
                fragment.setArguments(bundle);

                OpenFragment();
            }
        });
*/
        //fragment.setArguments(bundle);
        InitToolbar();
        return view;
    }
    private void  PassData()
    {
        Bundle bundle=new Bundle();
        bundle.putString("name", name.getText()+"");
        bundle.putString("numb", numb.getText()+"");
        bundle.putString("ID", Id.getText()+"");
        bundle.putString("email", email.getText()+"");

        fragment=new RequestTowFragment();
        fragment.setArguments(bundle);
        OpenFragment();
    }


    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }




    private  String  insertUser()
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
        Call<String> call = request.insertData("sdfsdfsdsdsdf",1);
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



        return  "ok";
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
              //  Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
              if (getFragmentManager().getBackStackEntryCount()==1)
              getActivity().finish();
              else
                  getFragmentManager().popBackStack();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

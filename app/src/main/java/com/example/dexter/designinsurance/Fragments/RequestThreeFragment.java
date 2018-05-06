package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
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

import com.example.dexter.designinsurance.MainActivity;
import com.example.dexter.designinsurance.Models.ResponseModel;
import com.example.dexter.designinsurance.R;
import com.example.dexter.designinsurance.Services.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obsez.android.lib.filechooser.ChooserDialog;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
     String UserFilePath;
    String randomIdFileName,randomDrivelicene,userIdPath,userDriveLPath;
    TextView content;
    Button confirminsurancerequestId,drivelicenceId,internationlIdFile,carLicenceIdFile;
    int flag=0;
    String _path,_path2,_path3;
    String IdFilePath="";
    String drivelicencePath="";
    String carlicencePath="";
    String name,numb,Id,branchNumber,insuarnceType,accountNumber,payMethod,email;
    ProgressDialog progressDialog;

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
        email=bundle.getString("email");
        branchNumber=bundle.getString("partionNumber");
        insuarnceType=bundle.getString("insuarnceType");
        accountNumber=bundle.getString("accountNumber");
        payMethod=bundle.getString("payMethod");
        confirminsurancerequestId=(Button)view.findViewById(R.id.confirminsurancerequestId);
        drivelicenceId=(Button)view.findViewById(R.id.drivelicenceId);
        internationlIdFile=(Button)view.findViewById(R.id.internationlIdFile);
        carLicenceIdFile=(Button)view.findViewById(R.id.carLicenceIdFile);


        progressDialog=new ProgressDialog(getActivity());

        drivelicenceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new ChooserDialog().with(getActivity())
                        .withFilter(false, false, "jpg", "jpeg", "png")
                        .withStartFile(_path)
                        .withResources(R.string.title_choose, R.string.title_choose, R.string.dialog_cancel)
                        .withChosenListener(new ChooserDialog.Result() {
                            @Override
                            public void onChoosePath(String path, File pathFile) {

                                drivelicencePath=path;
                            }
                        })
                        .build()
                        .show();

            }
        });
        internationlIdFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ChooserDialog().with(getActivity())
                        .withFilter(false, false, "jpg", "jpeg", "png")
                        .withStartFile(_path2)
                        .withResources(R.string.title_choose, R.string.title_choose, R.string.dialog_cancel)
                        .withChosenListener(new ChooserDialog.Result() {
                            @Override
                            public void onChoosePath(String path, File pathFile) {

                                IdFilePath=path;
                            }
                        })
                        .build()
                        .show();

            }
        });

        carLicenceIdFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new ChooserDialog().with(getActivity())
                        .withFilter(false, false, "jpg", "jpeg", "png")
                        .withStartFile(_path3)
                        .withResources(R.string.title_choose, R.string.title_choose, R.string.dialog_cancel)
                        .withChosenListener(new ChooserDialog.Result() {
                            @Override
                            public void onChoosePath(String path, File pathFile) {

                                carlicencePath=path;
                            }
                        })
                        .build()
                        .show();
            }
        });





        confirminsurancerequestId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IdFilePath.isEmpty()||drivelicencePath.isEmpty()||carlicencePath.isEmpty()) {
                    Toast.makeText(getActivity(),  "Please Choose  Files ", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AsyncTaskRunner().execute();

            }
        });



        return view;
    }





    private String  uploadFile(String path, final String Fname, final int Pflag)
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();

        Map<String, RequestBody> map = new HashMap<>();
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        final String extension = file.getName().split("\\.")[1];

        // map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
        map.put("file\"; filename=\"" + Fname+ "."+extension + "\"", requestBody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<ResponseModel> call = request.uploadFile(map);
      call.enqueue(new Callback<ResponseModel>() {
          @Override
          public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
              ResponseModel responsem=response.body();
              Toast.makeText(getActivity(), responsem.getMessage()+"",Toast.LENGTH_SHORT).show();
                String result = "http://snap-project.com/insuranceapis/uploads/" + Fname + "." + extension;
              userIdPath=result;

                /*  if (Pflag==0){
                    userIdPath=result;
                  }
                  else if(Pflag==1)
                      userDriveLPath=result;
                  else  if(Pflag==2)
                      carlicencePath=result;*/

          }

          @Override
          public void onFailure(Call<ResponseModel> call, Throwable t) {
              Toast.makeText(getActivity(), t.getMessage()+"",Toast.LENGTH_SHORT).show();

          }
      });


return  "";

    }




    private String  uploadFile2(String path, final String Fname, final int Pflag)
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();

        Map<String, RequestBody> map = new HashMap<>();
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        final String extension = file.getName().split("\\.")[1];

        // map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
        map.put("file\"; filename=\"" + Fname+ "."+extension + "\"", requestBody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<ResponseModel> call = request.uploadFile(map);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responsem=response.body();
                Toast.makeText(getActivity(), responsem.getMessage()+"",Toast.LENGTH_SHORT).show();
                String result = "http://snap-project.com/insuranceapis/uploads/" + Fname + "." + extension;
                userDriveLPath=result;

                /*  if (Pflag==0){
                    userIdPath=result;
                  }
                  else if(Pflag==1)
                      userDriveLPath=result;
                  else  if(Pflag==2)
                      carlicencePath=result;*/

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage()+"",Toast.LENGTH_SHORT).show();

            }
        });


        return  "";

    }



    private String  uploadFile3(String path, final String Fname, final int Pflag)
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();

        Map<String, RequestBody> map = new HashMap<>();
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        final String extension = file.getName().split("\\.")[1];

        // map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
        map.put("file\"; filename=\"" + Fname+ "."+extension + "\"", requestBody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://snap-project.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestInterface request = retrofit.create(RequestInterface.class);

        Call<ResponseModel> call = request.uploadFile(map);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responsem=response.body();
                Toast.makeText(getActivity(), responsem.getMessage()+"",Toast.LENGTH_SHORT).show();
                String result = "http://snap-project.com/insuranceapis/uploads/" + Fname + "." + extension;
                carlicencePath=result;
                /*  if (Pflag==0){
                    userIdPath=result;
                  }
                  else if(Pflag==1)
                      userDriveLPath=result;
                  else  if(Pflag==2)
                      carlicencePath=result;*/

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage()+"",Toast.LENGTH_SHORT).show();

            }
        });


        return  "";

    }




    protected String getRandomName() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    private  void   insertUser()
    {
        Toast.makeText(getActivity(),userIdPath+userDriveLPath,Toast.LENGTH_SHORT).show();
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
        Call<String> call = request.insertUser(name,Id,numb,email,branchNumber,insuarnceType,payMethod,accountNumber,userIdPath,userDriveLPath,carlicencePath);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                  Toast.makeText(getActivity(),"Success",Toast.LENGTH_SHORT).show();

                   Toast.makeText(getActivity(),response.body(),Toast.LENGTH_SHORT).show();

                progressDialog.dismiss();

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


        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                getFragmentManager().popBackStack();

                //  Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }





    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp="";

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                uploadFile(IdFilePath,getRandomName(),0);
                uploadFile2(drivelicencePath,getRandomName(),1);
                uploadFile3(carlicencePath,getRandomName(),2);
                int time = Integer.parseInt("20000");
                Thread.sleep(time);


            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {

           insertUser();
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getActivity(),
                    "ProgressDialog",
                    "Wait Please");
        }
    }




}


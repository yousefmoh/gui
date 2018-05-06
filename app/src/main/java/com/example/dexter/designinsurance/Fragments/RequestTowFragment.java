package com.example.dexter.designinsurance.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dexter.designinsurance.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dexter on 3/31/2018.
 */

public class RequestTowFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    View view;
    Fragment fragment;
    Toolbar toolbar;
    TextView titlebar;
    TextView content,accountNumberText;
    Button nextIdBtn;

    int test=0;
    String Name,ID,MobileNumber,email;
    EditText accountNumber;

    Adapter adapter;
    Spinner spinner,insuarnceType,payMethod;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.request_tow_fragment, container, false);
        Bundle bundle = this.getArguments();
        Name=bundle.getString("name");
        ID=bundle.getString("ID");
        MobileNumber=bundle.getString("numb");
        email=bundle.getString("email");
        InitItems();


        nextIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             //   Toast.makeText(getActivity(),spinner.getSelectedItem()+"",Toast.LENGTH_SHORT).show();

                if (accountNumber.getText().toString().isEmpty()&&accountNumber.getVisibility()==View.VISIBLE)
                {

                    Toast.makeText(getActivity(),"Plase Make sure that you insert all data! Thanks ",Toast.LENGTH_SHORT).show();
                    return;


                }

                PassData();


            }
        });


        InitToolbar();
        SetSpinnersContent();
        accountNumber.setVisibility(View.GONE);





        return view;
    }
    private  void  SetSpinnersContent()
    {
        List<String> list = new ArrayList<String>();
        list.add("نابلس");
        list.add("طولكرم");
        list.add("رام الله");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);


        List<String> insuracneTypelist = new ArrayList<String>();
        insuracneTypelist.add("نوع 1");
        insuracneTypelist.add("نوع 2");
        ArrayAdapter<String> insuranceAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, insuracneTypelist);


        List<String> payMethodList = new ArrayList<String>();
        payMethodList.add("نقدي");
        payMethodList.add("شيكات");
        ArrayAdapter<String> payMethodAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, payMethodList);




        payMethod.setAdapter(payMethodAdapter);
        insuarnceType.setAdapter(insuranceAdapter);
        spinner.setAdapter(dataAdapter);

    }
    private  void  InitItems()
    {   nextIdBtn=(Button)view.findViewById(R.id.nextIdBtn);
        insuarnceType=(Spinner)view.findViewById(R.id.insuranceType);
        payMethod=(Spinner)view.findViewById(R.id.payMethodId);
        accountNumber=(EditText)view.findViewById(R.id.accountNumber);
        spinner=(Spinner) view.findViewById(R.id.spinner);
        accountNumberText=(TextView) view.findViewById(R.id.accountNumberText);

        payMethod.setOnItemSelectedListener(this);

    }




    private void  PassData()
    {
        Bundle bundle=new Bundle();
        bundle.putString("name", Name);
        bundle.putString("numb", MobileNumber);
        bundle.putString("ID",ID);
        bundle.putString("email",email);

        bundle.putString("partionNumber",spinner.getSelectedItem()+"");
        bundle.putString("insuarnceType", insuarnceType.getSelectedItem()+"");

        bundle.putString("payMethod",payMethod.getSelectedItem()+"");

        if(accountNumber.getVisibility()==View.VISIBLE){
            bundle.putString("accountNumber",accountNumber.getText()+"");}
         else
        {
            bundle.putString("accountNumber","");
        }

        fragment=new RequestThreeFragment();
        fragment.setArguments(bundle);
        OpenFragment();
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
                getFragmentManager().popBackStack();

                //  Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0)
        {
            accountNumber.setVisibility(View.GONE);
         //   accountNumberText.setText(R.string.accountNumberS);

        }
else
    accountNumber.setVisibility(View.VISIBLE);
         accountNumberText.setText(R.string.accountNumberS);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

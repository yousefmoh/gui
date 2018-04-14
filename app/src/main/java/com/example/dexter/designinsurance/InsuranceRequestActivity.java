package com.example.dexter.designinsurance;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dexter.designinsurance.Fragments.FragmentHome;
import com.example.dexter.designinsurance.Fragments.RequestOneFragment;
import com.example.dexter.designinsurance.Fragments.RequestTowFragment;

public class InsuranceRequestActivity extends AppCompatActivity {
  public   int flag=0;
    Button nextBtn;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insurance_request);

        // Create new fragment and transaction
        fragment = new RequestOneFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    private  void  OpenFragment()
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}

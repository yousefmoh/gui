package com.example.dexter.designinsurance;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dexter.designinsurance.Fragments.FragmentHome;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;
    TextView testText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // TypefaceUtil.overrideFont(getApplicationContext(), "serif","fonts/test2.ttf");

       // DesignInsurance myapp=new DesignInsurance();

        // Create new fragment and transaction
        fragment = new FragmentHome();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

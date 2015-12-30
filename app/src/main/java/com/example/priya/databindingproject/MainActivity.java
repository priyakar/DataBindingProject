package com.example.priya.databindingproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.priya.databindingproject.databinding.ActivityMainBinding;
//import com.example.priya.databindingproject.model.User;
import com.example.priya.databindingproject.view.ViewModel;

public class MainActivity extends AppCompatActivity {
    ViewModel mPhonewordViewModel;
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhonewordViewModel = new ViewModel();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setPhonewordVM(mPhonewordViewModel);

        mBinding.callButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent callIntent = new Intent(Intent.ACTION_CALL);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder
                                .setMessage(mBinding.callButton.getText())
                                .setNeutralButton("call", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        callIntent.setData(Uri.parse("tel:" + mPhonewordViewModel.getPhoneNumber()));
                                        PhonewordUtils.savePhoneword(MainActivity.this, mPhonewordViewModel.getPhoneWord());
                                        startActivity(callIntent);
                                    }
                                })
                                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Nothing to do here.
                                    }
                                })
                                .show();
                    }
                }
        );


        mBinding.translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhonewordViewModel.setPhoneWord(mBinding.phonewordText.getText().toString());
                mPhonewordViewModel.translatePhoneWord();
            }
        });


    }
}

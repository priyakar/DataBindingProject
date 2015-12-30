package com.example.priya.databindingproject;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.example.priya.databindingproject.databinding.ActivityLandingBinding;
import com.example.priya.databindingproject.view.LandingViewModel;

public class LandingActivity extends AppCompatActivity {

    ActivityLandingBinding binding;
    LandingViewModel model;
    AnimationSet ripples;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);
        model = new LandingViewModel();
        binding.setLandingViewModel(model);
        binding.openMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, MainActivity.class));
            }
        });
        int visible =View.VISIBLE;
        binding.openMain.setVisibility(visible);
        ripples = new AnimationSet(true);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Animation zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        ripples.addAnimation(fadeOut);
        ripples.addAnimation(zoomOut);
        ripples.setDuration(3000);
        ripples.setRepeatCount(-1);
        binding.content.startRippleAnimation();

    }




}

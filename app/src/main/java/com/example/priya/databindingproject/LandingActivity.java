package com.example.priya.databindingproject;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.priya.databindingproject.databinding.ActivityLandingBinding;
import com.example.priya.databindingproject.view.LandingViewModel;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity {

    ActivityLandingBinding binding;
    LandingViewModel model;
    AnimatorSet ripples;
    Animator fade, zoom;
    ArrayList<Animator> animatorList;
    RelativeLayout.LayoutParams params;
    ArrayList<ImageView> imageList;
    private boolean animationRunning;

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
//                startActivity(new Intent(LandingActivity.this, MainActivity.class));
                startRippleAnimation();
            }
        });
//        int visible = View.VISIBLE;
//        binding.openMain.setVisibility(visible);
        imageList = new ArrayList<>();
        animatorList = new ArrayList<>();
        ripples = new AnimatorSet();
        ripples.setDuration(4000);
        ripples.setInterpolator(new AccelerateDecelerateInterpolator());

        params = new RelativeLayout.LayoutParams((int) getResources().getDimension(R.dimen.image_size),
                (int) getResources().getDimension(R.dimen.image_size));
        fade = AnimatorInflater.loadAnimator(this, R.animator.fade_out_animation);
        zoom = AnimatorInflater.loadAnimator(this, R.animator.zoom_out_animation);
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.oval_shape, null));
//            imageView.setVisibility(View.INVISIBLE);
            imageView.setMaxWidth(100);
            imageView.setMaxHeight(100);
            binding.rootView.addView(imageView);
            imageList.add(imageView);

            final ObjectAnimator alphaAnimator= ObjectAnimator.ofFloat(imageView, "Alpha", 1.0f, 0f);
            alphaAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            alphaAnimator.setRepeatMode(ObjectAnimator.RESTART);
            alphaAnimator.setStartDelay(i * (3000/3));
            animatorList.add(alphaAnimator);
            final ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imageView, "ScaleX", 1.0f, 6);
            scaleXAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            scaleXAnimator.setRepeatMode(ObjectAnimator.RESTART);
            scaleXAnimator.setStartDelay(i*(3000/3));
            animatorList.add(scaleXAnimator);
            final ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imageView, "ScaleY", 1.0f, 6);
            scaleYAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            scaleYAnimator.setRepeatMode(ObjectAnimator.RESTART);
            scaleYAnimator.setStartDelay(i*(3000/3));
            animatorList.add(scaleYAnimator);
        }
//        binding.content.startAnimation(ripples);
        ripples.playTogether(animatorList);
//        startRippleAnimation();
    }

    public void startRippleAnimation() {
        if (!isRippleAnimationRunning()) {
            for (ImageView rippleView : imageList) {
                rippleView.setVisibility(View.VISIBLE);
            }
//            ripples.playTogether(animatorList);
            ripples.start();
            animationRunning = true;
        }
    }

    public void stopRippleAnimation() {
        if (isRippleAnimationRunning()) {
            animationRunning = false;
        }
    }

    public boolean isRippleAnimationRunning() {
        return animationRunning;
    }


}

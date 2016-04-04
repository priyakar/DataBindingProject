package com.example.priya.databindingproject;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.priya.databindingproject.databinding.ActivityLandingBinding;
import com.example.priya.databindingproject.view.LandingViewModel;

public class LandingActivity extends AppCompatActivity {

    ActivityLandingBinding binding;
    LandingViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);
        model = new LandingViewModel();
        binding.setLandingViewModel(model);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View rowView) {
            super(rowView);
            binding = DataBindingUtil.bind(rowView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}

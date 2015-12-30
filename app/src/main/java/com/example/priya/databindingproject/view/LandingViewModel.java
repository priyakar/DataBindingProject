package com.example.priya.databindingproject.view;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Button;

public class LandingViewModel extends BaseObservable {
    public String text = "";
    public String openMain;

    public LandingViewModel() {
    }

    @Bindable
    public String getText() {
        return text;
    }

    @Bindable
    public String getOpenMain() {
        return openMain;
    }
}

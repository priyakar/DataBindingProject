package com.example.priya.databindingproject.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;

import com.example.priya.databindingproject.BR;

public class ViewModel extends BaseObservable {

    private boolean mIsTranslated = false;
    private String mPhoneNumber = "";
    private String mPhoneWord = "";
    private String mCallButtonText = "Call";

    @Bindable
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    @Bindable
    public String getCallButtonText() {
        return mCallButtonText;
    }

    @Bindable
    public boolean getIsTranslated() {
        return mIsTranslated;
    }

    @Bindable
    public String getPhoneWord() {
        return mPhoneWord;
    }


    public void setPhoneWord(String phoneWord) {
        mPhoneWord = phoneWord;
        notifyPropertyChanged(BR.phoneWord);
    }

    public void translatePhoneWord() {
        mPhoneNumber = PhonewordUtils.toNumber(mPhoneWord);

        if (TextUtils.isEmpty(mPhoneNumber)) {
            mCallButtonText = "Call";
            mIsTranslated = false;
        } else {
            mIsTranslated = true;
            mCallButtonText = "Call " + mPhoneNumber + "?";
        }
        notifyPropertyChanged(BR.phoneNumber);
        notifyPropertyChanged(BR.isTranslated);
        notifyPropertyChanged(BR.callButtonText);
    }

    public void onTranslate(View v) {
        translatePhoneWord();
    }
}

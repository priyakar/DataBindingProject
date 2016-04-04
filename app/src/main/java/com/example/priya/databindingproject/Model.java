package com.example.priya.databindingproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Model extends BaseAdapter {
    public final String firstName;

    public Model(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

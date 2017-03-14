package com.example.sample.sampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andabucsa on 3/13/17.
 */

public class SecondPage extends Fragment {

    public static SecondPage newInstance() {
        return new SecondPage();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("log", "onCreateView second page");
        return inflater.inflate(R.layout.second_page_fragment, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("log", "ondetach second page");
    }
}

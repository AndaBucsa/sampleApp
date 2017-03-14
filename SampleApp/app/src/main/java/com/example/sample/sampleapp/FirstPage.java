package com.example.sample.sampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by andabucsa on 3/13/17.
 */

public class FirstPage extends Fragment {

    public static FirstPage newInstance() {
        return new FirstPage();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_page_fragment, container, false);
        Button button = (Button) view.findViewById(R.id.pressMeButton);
        Log.d("log", "onCreateView first page");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(R.id.content_frame, SecondPage.newInstance(), true, true);
            }
        });
        return view;
    }

    public void openFragment(int containerID, Fragment fragment, boolean replace, boolean withAnimation) {
        // The following check is needed to avoid committing a fragment transaction if the parent activity
        // looses it’s state (onSaveInstanceState was already called)
        // https://jira.mywebgrocer.com/browse/MOBPS-13091
        if (getActivity() != null) {
            String fragmentTagName = fragment.getClass().getCanonicalName();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

            if (replace) {
                fragmentTransaction.replace(containerID, fragment, fragmentTagName);
            } else {
                fragmentTransaction.add(containerID, fragment, fragmentTagName);
            }

            fragmentTransaction.addToBackStack(fragmentTagName);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        
        Log.d("log", "ondetach first page");
    }
}

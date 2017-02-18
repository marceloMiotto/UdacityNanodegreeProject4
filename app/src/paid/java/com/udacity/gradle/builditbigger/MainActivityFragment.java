package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivityFragment extends Fragment implements View.OnClickListener {

    View root;
    Button button;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
        button = (Button) root.findViewById(R.id.joke_button_id);
        button.setOnClickListener(this);
        return root;
    }


    @Override
    public void onClick(View v) {
        new EndpointsAsyncTask(root).execute(getActivity());
    }
}


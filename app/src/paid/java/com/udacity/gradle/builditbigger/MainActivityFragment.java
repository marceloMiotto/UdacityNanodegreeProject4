package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityFragment extends Fragment implements View.OnClickListener {

    View root;
    Button button;
    TextView instructionsTextView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
        button = (Button) root.findViewById(R.id.joke_button_id);
        button.setOnClickListener(this);
        instructionsTextView = (TextView) root.findViewById(R.id.instructions_text_view);
        return root;
    }


    @Override
    public void onClick(View v) {

        NetworkUtils networkUtils = new NetworkUtils(getActivity());
        if(networkUtils.isConnected()){
            new EndpointsAsyncTask(root).execute(getActivity());
        }else{
            instructionsTextView.setText(getActivity().getResources().getString(R.string.no_network_conn));
        }

    }


}


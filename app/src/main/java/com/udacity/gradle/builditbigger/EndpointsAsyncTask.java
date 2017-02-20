package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.marcelo_miotto.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import udacitynano.com.br.jokerdipslay.Constant;
import udacitynano.com.br.jokerdipslay.JokerDisplayActivity;

import static android.R.attr.name;


public  class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi myApiService = null;
    private Context context;
    private GetTaskListener mListener = null;
    ProgressBar progressBar;

    public EndpointsAsyncTask(){}

    public EndpointsAsyncTask(View rootView){

        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(Context... params) {



            if(myApiService == null) {  // Only do this once

                /*
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://192.168.0.5:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });

                // end options for devappserver
                */
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("http://192.168.0.5:8080/_ah/api/");


                myApiService = builder.build();
            }

        if(params.length > 0) {
            context = params[0];
        }

        if(mListener != null) {
            mListener.onComplete("test");
        }


        try {
                return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if(context != null) {
            Intent intent = new Intent(context, JokerDisplayActivity.class);
            intent.putExtra(Constant.JOKER_CONTENT, result);
            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }

    }

    public EndpointsAsyncTask setListener(GetTaskListener listener) {
        mListener = listener;
        return this;
    }

    public interface GetTaskListener {
        void onComplete(String result);
    }
}

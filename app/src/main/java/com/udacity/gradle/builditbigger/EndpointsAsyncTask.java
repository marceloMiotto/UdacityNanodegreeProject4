package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.marcelo_miotto.myapplication.backend.myApi.MyApi;

import udacitynano.com.br.jokerdipslay.Constant;
import udacitynano.com.br.jokerdipslay.JokerDisplayActivity;


public  class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi myApiService = null;
    private Context context;
    private GetTaskListener mListener = null;

    @Override
    protected String doInBackground(Context... params) {

            /*

            if(myApiService == null) {  // Only do this once

                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });

                // end options for devappserver

                myApiService = builder.build();
            }
*/
        if(params.length > 0) {
            context = params[0];
        }

        if(mListener != null) {
            mListener.onComplete("test");
        }

        //try {
        // return myApiService.sayHi(name).execute().getData();
        return "joke generated. ";
        //} catch (IOException e) {
        //    return e.getMessage();
        // }
    }

    @Override
    protected void onPostExecute(String result) {

        if(context != null) {
            Intent intent = new Intent(context, JokerDisplayActivity.class);
            intent.putExtra(Constant.JOKER_CONTENT, result);
            context.startActivity(intent);
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

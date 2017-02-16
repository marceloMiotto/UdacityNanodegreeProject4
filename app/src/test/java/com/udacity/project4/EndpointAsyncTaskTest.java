package com.udacity.project4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;

public class EndpointAsyncTaskTest  {

    String mResult = null;
    CountDownLatch signal = null;


    @Before
    public void setUp(){
        signal = new CountDownLatch(1);
    }


    @Test(timeout=5000)
    public void asyncTaskTest() throws InterruptedException {


        EndpointsAsyncTask task = new EndpointsAsyncTask();
            task.setListener(new EndpointsAsyncTask.GetTaskListener() {
                @Override
                public void onComplete(String result) {
                    mResult = result;
                    signal.countDown();
                }
            }).execute();
        signal.await();

        assertNotNull(mResult);
    }
}

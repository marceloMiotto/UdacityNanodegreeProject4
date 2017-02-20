package com.udacity.project4;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class MyJokerModelTest {
    @Test
    public void test() {
        MyJokerModel joker = new MyJokerModel("Joke Test","Author Test");
        assert joker.getJoke().length() != 0;
    }

    @Test
    public void resourceTest(){

        MyJokerResource myJokerResource = new MyJokerResource();
        assertNotNull(myJokerResource.getJoke());
    }

}



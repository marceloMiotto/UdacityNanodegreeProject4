package com.udacity.project4;

import org.junit.Test;

public class MyJokerModelTest {
    @Test
    public void test() {
        MyJokerModel joker = new MyJokerModel();
        assert joker.getJoke().length() != 0;
    }
}



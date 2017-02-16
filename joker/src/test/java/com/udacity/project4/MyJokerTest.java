package com.udacity.project4;

import org.junit.Test;

public class MyJokerTest {
    @Test
    public void test() {
        MyJoker joker = new MyJoker();
        assert joker.getJoke().length() != 0;
    }
}



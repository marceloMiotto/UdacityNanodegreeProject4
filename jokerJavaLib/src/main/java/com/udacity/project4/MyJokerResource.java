package com.udacity.project4;


public class MyJokerResource {


    public String getJoke(){

        MyJokerService myJokerService = new MyJokerService();

        int randomJoke = (int) (Math.random() * 3);;
        return myJokerService.getJoke(randomJoke);

    }


}

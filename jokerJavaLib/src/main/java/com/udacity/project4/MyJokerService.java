package com.udacity.project4;


public class MyJokerService {

    private MyJokerModel[] jokers = new MyJokerModel[3];

    public MyJokerService(){
        jokers[0] = new MyJokerModel("Next time I send a damn fool, I go myself.","Sgt. Louis Cukela, reportedly said at the Battle of Belleau Wood during World War I");
        jokers[1] = new MyJokerModel("The four most beautiful words in our common language: I told you so.","Gore Vidal");
        jokers[2] = new MyJokerModel("Some people just have a way with words, and other people … oh … not have way.","Steve Martin");
    }

    public String getJoke(int jokeId){
        return jokers[jokeId].getJoke()+"\n\n"+"Author: "+jokers[jokeId].getAuthor();
    }

}

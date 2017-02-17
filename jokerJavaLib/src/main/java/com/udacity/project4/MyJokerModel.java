package com.udacity.project4;

public class MyJokerModel {


    private String joke;
    private String author;

    public MyJokerModel(String joke, String author) {
        this.joke = joke;
        this.author = author;
    }


    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getJoke(){
        return this.joke;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

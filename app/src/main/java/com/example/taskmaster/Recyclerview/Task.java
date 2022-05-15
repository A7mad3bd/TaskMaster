package com.example.taskmaster.Recyclerview;

public class Task {

    public String title;
    public String body;
    public String state ;

    public Task(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state = state;
    }



    @Override
    public String toString() {
        return getBody()+" "+getTitle();
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getState() {
        return state;
    }


}

package com.example.taskmaster.Recyclerview;

public class Task {

    public static String title;
    public static String body;
    public static String state ;

    public Task(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state = state;
    }

    public static void setTitle(String title) {
        Task.title = title;
    }

    public static void setBody(String body) {
        Task.body = body;
    }

    public static void setState(String state) {
        Task.state = state;
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

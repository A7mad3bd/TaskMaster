package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Task_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        getTask();
    }


    public void getTask() {

        TextView textView = findViewById(R.id.Task_name);
        String task = getIntent().getExtras().get("title").toString();
        textView.setText(task);

    }
}
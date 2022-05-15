package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.taskmaster.Recyclerview.ViewAdapter;

public class Task_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        getData();


    }

    public void getData() {


        TextView Task_Title__String = findViewById(R.id.Task_name);

        String Tasktitle = getIntent().getExtras().get("title").toString();
        Task_Title__String.setText(Tasktitle);



        //     Intent intent = getIntent();
        //        TextView Task_Body_String = findViewById(R.id.Task_Body);
//        TextView Task_State_String = findViewById(R.id.Task_State);
//        if (intent != null) {
//            String Tasktitle = getIntent().getExtras().get("title").toString();
//            Task_Title__String.setText(Tasktitle);
//
//            String Taskbody = getIntent().getExtras().get("body").toString();
//            Task_Body_String.setText(Taskbody);
//
//            String Taskstate = getIntent().getExtras().get("state").toString();
//            Task_State_String.setText(Taskstate);
//
//        }
    }
}
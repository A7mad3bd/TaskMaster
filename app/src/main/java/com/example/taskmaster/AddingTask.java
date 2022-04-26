package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class AddingTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_task);
        Button addTask = findViewById(R.id.ADDTASKA);
        addTask.setOnClickListener(v -> {
            Toast.makeText(this, "submitted", Toast.LENGTH_SHORT).show();
        });
    }
}
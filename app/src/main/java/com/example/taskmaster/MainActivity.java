package com.example.taskmaster;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button, button1, button2;
    private TextView mUsernameText;

//    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // this is a good place to do initial
        // set up like click listeners etc
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSubmit = findViewById(R.id.btn_submit);
        mUsernameText = findViewById(R.id.Write_your_username);

        Log.i(TAG, "onCreate: Called");

        button = (Button) findViewById(R.id.ADDTASK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        button1 = (Button) findViewById(R.id.AllTasks);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        button2 = (Button) findViewById(R.id.Settings);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Settings = new Intent(MainActivity.this, Settings.class);
                startActivity(Settings);
            }
        });

        Button Task1 = findViewById(R.id.Task1);
        Task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Task1 = new Intent(MainActivity.this, Task_Detail.class);
                Task1.putExtra("title", "Task 1");
                startActivity(Task1);
            }
        });

        Button Task2 = findViewById(R.id.Task2);
        Task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Task2 = new Intent(MainActivity.this, Task_Detail.class);
                Task2.putExtra("title", "Task 2");
                startActivity(Task2);
            }
        });
    }

    public void openActivity1() {
        Intent intent = new Intent(this, AllTasks.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, AddingTask.class);
        startActivity(intent);
    }

    public void getusername() {
        TextView textView = findViewById(R.id.username);
        String task = getIntent().getExtras().get("username").toString();
        textView.setText(task);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void navigateToSettings() {
        Intent settingsIntent = new Intent(this, Settings.class);
        startActivity(settingsIntent);
    }

    private void navigateToAllTasks() {
        Intent settingsIntent = new Intent(this, AllTasks.class);
        startActivity(settingsIntent);
    }

    private void navigateToAddTask() {
        Intent settingsIntent = new Intent(this, AddingTask.class);
        startActivity(settingsIntent);
    }

    private void navigateToMain() {
        Intent settingsIntent = new Intent(this, MainActivity.class);
        startActivity(settingsIntent);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Homepage:
                navigateToMain();
                return true;
            case R.id.action_settings:
                navigateToSettings();
                return true;
            case R.id.Add_Task:
                navigateToAddTask();
                return true;
            case R.id.AllTasks:
                navigateToAllTasks();
                return true;
            case R.id.action_copyright:
                Toast.makeText(this, "Copyright 2022", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUsername() {
        // get text out of shared preference
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // set text on text view address widget
        mUsernameText.setText(sharedPreferences.getString(Settings.USERNAME, "No Username Set"));
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: called");
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: called - The App is VISIBLE");

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: called");
        setUsername();
        getusername();
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: called");
        super.onDestroy();
    }
}
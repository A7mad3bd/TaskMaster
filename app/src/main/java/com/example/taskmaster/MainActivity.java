package com.example.taskmaster;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button,button1;
//    private final View.OnClickListener mClickMeButtonListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            mGreetingText.setAllCaps(true);
//
//            // create intent for navigation
////            Intent startSecondActivityIntent = new Intent(getApplicationContext(), AddingTask.class);
////
////            // start / navigate to the next activity
////            startActivity(startSecondActivityIntent);
//        }
//    };
//    private TextView mGreetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // this is a good place to do initial
        // set up like click listeners etc
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void openActivity1() {
        Intent intent = new Intent(this, AllTasks.class);
        startActivity(intent);
    }
    public void openActivity2() {
        Intent intent = new Intent(this, AddingTask.class);
        startActivity(intent);
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
//*
//private Button button;
//        button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(this, Activity2.class);
////        startActivity(intent);
//            }
//        });
//    }

// */
}
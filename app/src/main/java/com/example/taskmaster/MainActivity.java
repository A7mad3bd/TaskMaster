package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskmaster.DB.AppDB;
import com.example.taskmaster.Recyclerview.ViewAdapter;
import com.example.taskmaster.Recyclerview.Task;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button, button1, button2, button3, button4;
    private TextView mUsernameText;
    RecyclerView rrecyclerview;
    List<Task> Tasklist;
    ViewAdapter myadapter;
    SharedPreferences sharedpreferencesmain;
    List<Task> TasklistDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.ADDTASK);
        mUsernameText = (TextView) findViewById(R.id.username);
        rrecyclerview = findViewById(R.id.rere);
        button1 = (Button) findViewById(R.id.AllTasks);
        button2 = (Button) findViewById(R.id.Settings);
        TasklistDB = AppDB.getInstance(this).taskDao().getAll();


        SetUserName();
        AddTakInfo();
        SetAdapter();
        OnclistButtons();


        Log.i(TAG, "onCreate: Called");
    }

    private void SetUserName() {
        sharedpreferencesmain = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        String usernamemain = sharedpreferencesmain.getString("username", "");
        mUsernameText.setText(usernamemain);
    }

    private void OnclistButtons() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Settings = new Intent(MainActivity.this, Settings.class);
                startActivity(Settings);
            }
        });

//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent Task1 = new Intent(MainActivity.this, Task_Detail.class);
//                Task1.putExtra("title", "Task 1");
//                startActivity(Task1);
//            }
//        });
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent Task2 = new Intent(MainActivity.this, Task_Detail.class);
//                Task2.putExtra("title", "Task 2");
//                startActivity(Task2);
//            }
//        });
    }

    private void AddTakInfo() {

        TasklistDB.add(new Task("one", "Task 26 ", "complete"));
        TasklistDB.add(new Task("two", "Task 27 ", "complete"));
        TasklistDB.add(new Task("3", "Task 28 ", "in progress"));
        TasklistDB.add(new Task("4", "Task 29 ", "in progress"));

    }

    private void SetAdapter() {


        ViewAdapter customRecyclerView = new ViewAdapter(TasklistDB, new ViewAdapter.MyOnClickListener() {
            @Override
            public void onClicked(Task task) {
//                Log.d(TAG, "onClicked: "+task.getId());
                Intent taskDetailActivity = new Intent(getApplicationContext(), Task_Detail.class);
//                Toast.makeText(MainActivity.this, "000" , Toast.LENGTH_SHORT).show();
                taskDetailActivity.putExtra("title", task.title);
                taskDetailActivity.putExtra("body", task.body);
                taskDetailActivity.putExtra("state", task.state);

                startActivity(taskDetailActivity);
            }
        });

        rrecyclerview.setAdapter(customRecyclerView);
        rrecyclerview.setHasFixedSize(true);
        rrecyclerview.setLayoutManager(new
                LinearLayoutManager(this));

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

}
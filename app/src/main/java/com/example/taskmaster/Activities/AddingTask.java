package com.example.taskmaster.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.example.taskmaster.DB.AppDB;
import com.example.taskmaster.R;
import com.example.taskmaster.Recyclerview.Task;


import java.util.ArrayList;
import java.util.List;

public class AddingTask extends AppCompatActivity {
    SharedPreferences sharedpreferencesaddtask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        List<Task> TasklistDB;
        List<com.amplifyframework.datastore.generated.model.Task> TasklistDB = new ArrayList<>();

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_adding_task);
        Button addTask = findViewById(R.id.ADDTASKA);
//        TasklistDB = AppDB.getInstance(this).taskDao().getAll();
        TextView TotalTasks = (TextView) findViewById(R.id.TotalTasksText1);
        String s = String.valueOf(TasklistDB.size());
        TotalTasks.setText(s);

        TotalTasks.setText("3");
        addTask.setOnClickListener(v -> {

            Toast.makeText(this, "submitted", Toast.LENGTH_SHORT).show();
        });
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText Task_name = findViewById(R.id.Tasknamee);
                String Taskname = Task_name.getText().toString();

                EditText Task_body = findViewById(R.id.Taskbodyy);
                String Taskbody = Task_body.getText().toString();

                Spinner Task_Stast = findViewById(R.id.TaskStatee);
                String TaskStast = Task_Stast.getSelectedItem().toString();

                Task task = new Task(Taskname, Taskbody, TaskStast);

                Long newTaskId = AppDB.getInstance(getApplicationContext()).taskDao().insertTask(task);

                com.amplifyframework.datastore.generated.model.Task item = com.amplifyframework.datastore.generated.model.Task
                        .builder()
                        .title(Taskname)
                        .description(Taskbody)
                        .status(TaskStast).build();
                Amplify.API.query(ModelMutation.create(item),
                        res -> {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                        , err -> {
                        });
//                TasklistDB.add(task);
//                System.out.println("******************** Task ID = " + newTaskId + " ************************");

            }
        });

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

    private void navigateToMain() {
        Intent settingsIntent = new Intent(this, MainActivity.class);
        startActivity(settingsIntent);
    }
}
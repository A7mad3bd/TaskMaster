package com.example.taskmaster;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;

import android.view.inputmethod.InputMethodManager;
import android.util.Log;
import android.widget.EditText;


public class Settings extends AppCompatActivity {
    private static final String TAG = Settings.class.getSimpleName();
    public static final String USERNAME = "UserName";
    private EditText mUsernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mUsernameEditText = findViewById(R.id.Write_your_username);
        Button btnSubmit = findViewById(R.id.btn_submit);

        Button button = findViewById(R.id.btn_submit);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                TextInputEditText textInputEditText = findViewById(R.id.Write_your_username);
//                String username = textInputEditText.getText().toString();
//
//                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settings.this);
//
//                SharedPreferences.Editor share = sharedPreferences.edit();
//                share.putString("username",username);
//                share.apply();
//
//                Toast.makeText(Settings.this,username,Toast.LENGTH_LONG).show();
//                Intent Addusername= new Intent(Settings.this,MainActivity.class);
//                startActivity(Addusername);
//            }
//        });






        btnSubmit.setOnClickListener(view -> {
            Log.i(TAG, "Save button clicked");

            TextInputEditText textInputEditText = findViewById(R.id.Write_your_username);
            String username = textInputEditText.getText().toString();

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settings.this);

            SharedPreferences.Editor share = sharedPreferences.edit();
            share.putString("username",username);
            share.apply();
            // make sure the mUsernameEditText is greater than 10 characters
            if (mUsernameEditText.getText().toString().length() >= 10) {
                saveUsername();
            } else {
                Toast.makeText(this, "Add a longer Username", Toast.LENGTH_SHORT).show();
            }

            // Check if no view has focus: https://stackoverflow.com/questions/1109022/how-to-close-hide-the-android-soft-keyboard-programmatically
            View view2 = this.getCurrentFocus();
            if (view2 != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view2.getWindowToken(), 0);
            }
        });

        mUsernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i(TAG, "onTextChanged: the text is : " + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "afterTextChanged: the final text is : " + editable.toString());
                if (!btnSubmit.isEnabled()) {
                    btnSubmit.setEnabled(true);
                }

                if (editable.toString().length() == 0) {
                    btnSubmit.setEnabled(false);
                }

            }
        });
    }

    private void saveUsername() {
        String username = mUsernameEditText.getText().toString();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();

        preferenceEditor.putString(USERNAME, username);
        preferenceEditor.apply();

        Toast.makeText(this, "Username Saved", Toast.LENGTH_SHORT).show();
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
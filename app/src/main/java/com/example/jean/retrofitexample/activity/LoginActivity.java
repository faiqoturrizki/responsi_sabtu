package com.example.jean.retrofitexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jean.retrofitexample.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void gotomenu(View view) {
        Intent intent=new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}

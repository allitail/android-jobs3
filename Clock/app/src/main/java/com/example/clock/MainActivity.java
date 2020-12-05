package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView viewtime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewtime = (TextView) findViewById(R.id.viewtime);
        viewtime.setTextSize(30);

        Thread threaad = new Thread() {
            @Override
            public void run() {

            }
        };
    }














}
package com.example.practical8c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ProgressBar bar;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
        bar = (ProgressBar) findViewById(R.id.progressBar1);
    }
        public void startProgress(View view) { bar.setProgress(0);
            new Thread(new Task()).start();
            new Thread(new Task2()).start();
        }
        class Task implements Runnable { @Override public void run() {
            for (int i = 0; i <= 10; i++)
            {
                final int value = i;
                try {

                Thread.sleep(1000);
            } catch (InterruptedException e) { e.printStackTrace();}
                bar.setProgress(value);
            }
        }
        }
        class Task2 implements Runnable {
            @Override
            public void run() {


                for (int i = 10; i >= 0; i--) {
                    final int value = i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textView.setText(String.valueOf(value));

                }
            }
        }}
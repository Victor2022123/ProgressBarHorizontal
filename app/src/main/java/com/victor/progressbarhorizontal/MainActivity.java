package com.victor.progressbarhorizontal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int progress = 0;

    ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                setProgressValue(progress);


            }

        });
    }

    private void setProgressValue(final int progress) {

        simpleProgressBar.setProgress(progress);

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
            });
      thread.start();
        }
    }

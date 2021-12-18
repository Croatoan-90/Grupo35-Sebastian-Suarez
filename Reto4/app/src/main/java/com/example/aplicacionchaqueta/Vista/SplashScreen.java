package com.example.aplicacionchaqueta.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aplicacionchaqueta.Controlador.MainActivity;
import com.example.aplicacionchaqueta.R;

public class SplashScreen extends AppCompatActivity {

    private Thread h1;
    private ImageView iconLoading;
    private ProgressBar progressBar;
    private TextView percent;
    private Handler handler = new Handler();
    private int number = 0;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        iconLoading = (ImageView) findViewById(R.id.iconLoading);
        iconLoading.setImageResource(R.drawable.icon);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        percent = (TextView) findViewById(R.id.percent);

        h1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (number <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            percent.setText(number + " %");
                            progressBar.setProgress(number);
                        }
                    });
                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (number == 100) {
                        pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(pasarPantalla);
                    }
                    number++;
                }
            }
        });
        h1.start();
    }

}

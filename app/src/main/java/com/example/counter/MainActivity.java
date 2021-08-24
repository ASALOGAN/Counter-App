package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int Counter = 0;
    Button str,stp,clr;
    TextView txt;
    Handler custom = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str = (Button) findViewById(R.id.START1);
        stp = (Button) findViewById(R.id.STOP2);
        txt = (TextView) findViewById(R.id.COUNTER);
        clr = (Button) findViewById(R.id.CLEAR);

        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom.postDelayed(updateTimerThread, 0);

            }
        });
        stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom.removeCallbacks(updateTimerThread);
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom.removeCallbacks(updateTimerThread);
                txt.setText("0");
                Counter = 0;
            }
        });
    }
    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            txt.setText("" + Counter);
            custom.postDelayed(this, 1000);
            Counter++;
        }
    };
}
package com.example.priya.seekbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView  resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBarID);
        resultTextView = findViewById(R.id.resultID);

        resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress >= 7) {
                    resultTextView.setTextColor(Color.RED);
                } else {
                    resultTextView.setTextColor(Color.BLACK);
                }

                Log.d("SB", "Onprogress!");
                resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB", "OnStartTrackingTouch!");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("SB", "OnStop!");
            }
        });
    }
}

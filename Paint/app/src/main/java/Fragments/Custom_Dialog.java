package Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.priya.paint.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Priya on 7/14/2018.
 */

public class Custom_Dialog extends Dialog implements View.OnClickListener{

    public Context activity;
    public Dialog dialog;

    private SeekBar mSeekbar;

    public Custom_Dialog(Context activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.brush_size_dialog);
        final TextView customMessage = findViewById(R.id.customMessage);
        customMessage.setText("Brush Width: 0%");
        customMessage.setTextColor(Color.WHITE);
        mSeekbar = findViewById(R.id.seekBar);


        mSeekbar.setMax(100);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SB", "Onprogress!");
                customMessage.setText("Brush Width: " + seekBar.getProgress() + "%");
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

    @Override
    public void onClick(View view) {

    }
}

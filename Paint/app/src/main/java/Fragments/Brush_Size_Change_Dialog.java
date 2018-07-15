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
import android.widget.Button;
import android.widget.Toast;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Priya on 7/14/2018.
 */

public class Brush_Size_Change_Dialog extends Dialog implements View.OnClickListener{

    public Context activity;
    public CanvasView canvasView;
    public Dialog dialog;

    private SeekBar mSeekbar;
    private Button save;

    public Brush_Size_Change_Dialog(Context activity, CanvasView canvasView) {
        super(activity);
        this.activity = activity;
        this.canvasView = canvasView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.brush_size_dialog);
        final TextView customMessage = findViewById(R.id.customMessage);
        save = findViewById(R.id.save_brush_size);
        save.setBackgroundColor(Color.TRANSPARENT);
        save.setTextColor(Color.WHITE);
        customMessage.setText("Brush Width: 0%");
        customMessage.setTextColor(Color.WHITE);
        mSeekbar = findViewById(R.id.seekBar);


        mSeekbar.setMax(10);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SB", "Onprogress!");
                customMessage.setText("Brush Width: " + seekBar.getProgress()*10 + "%");
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
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String percentage = customMessage.getText().toString().trim();
                String[] percentageArray = percentage.split(":");
                String percentageValue = percentageArray[1].replace("%", "");
                customMessage.setText("Saved");
                setBrushStrokeSize(Integer.parseInt(percentageValue.trim()));
                dismiss();
            }
        });


    }

    public void setBrushStrokeSize(int percent_value) {
        if(percent_value == 10) {
            canvasView.getmPaint().setStrokeWidth(4f);
        }
        else if(percent_value == 20) {
            canvasView.getmPaint().setStrokeWidth(24f);
        }
        else if(percent_value == 30) {
            canvasView.getmPaint().setStrokeWidth(34f);
        }
        else if(percent_value == 40) {
            canvasView.getmPaint().setStrokeWidth(44f);
        }
        else if(percent_value == 50) {
            canvasView.getmPaint().setStrokeWidth(54f);
        }
        else if(percent_value == 60) {
            canvasView.getmPaint().setStrokeWidth(54f);
        }
        else if(percent_value == 70) {
            canvasView.getmPaint().setStrokeWidth(64f);
        }
        else if(percent_value == 80) {
            canvasView.getmPaint().setStrokeWidth(74f);
        }else if(percent_value == 90) {
            canvasView.getmPaint().setStrokeWidth(84f);
        }else if(percent_value == 100) {
            canvasView.getmPaint().setStrokeWidth(94f);
        } else {
            canvasView.getmPaint().setStrokeWidth(4f);
        }
    }

    @Override
    public void onClick(View view) {

    }
}

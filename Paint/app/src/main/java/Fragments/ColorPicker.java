package Fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.R;
import com.xiaopo.flying.sticker.StickerView;

import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * Created by Priya on 7/14/2018.
 */
public class ColorPicker extends Dialog implements View.OnClickListener{

    public Context activity;
    public CanvasView canvasView;
    StickerView stickerView;
    public Dialog dialog;


    private Button saveButton;
    private SeekBar red_SeekBar;
    private SeekBar green_SeekBar;
    private SeekBar blue_SeekBar;




    public ColorPicker(Context activity, CanvasView canvasView) {
        super(activity);
        this.activity = activity;
        this.canvasView = canvasView;

    }

    public ColorPicker(Context activity, StickerView stickerView) {
        super(activity);
        this.activity = activity;
        this.stickerView = stickerView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.color_change_dialog);

        saveButton = findViewById(R.id.color_save);
        red_SeekBar = findViewById(R.id.seekBarRed);
        green_SeekBar = findViewById(R.id.seekBarGreen);
        blue_SeekBar = findViewById(R.id.seekBarBlue);
        final TextView redView = findViewById(R.id.red_textView);
        final TextView greenView = findViewById(R.id.green_textView);
        final TextView blueView = findViewById(R.id.blue_textView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int red = Integer.parseInt(redView.getText().toString().trim());
                int green = Integer.parseInt(greenView.getText().toString().trim());
                int blue = Integer.parseInt(blueView.getText().toString().trim());
                Path mPath;
                Paint mPaint;

                mPath = new Path();

                // and we set a new Paint with the desired attributes
                if(canvasView != null) {
                    mPaint = new Paint();
                    mPaint.setAntiAlias(true);
                    mPaint.setColor(Color.rgb(red, green, blue));
                    mPaint.setStyle(Paint.Style.STROKE);
                    mPaint.setStrokeJoin(Paint.Join.ROUND);
                    mPaint.setStrokeWidth(canvasView.getmPaint().getStrokeWidth());
                    canvasView.addPath(mPath);
                    canvasView.addPaint(mPaint);
                    canvasView.setmPaint(mPaint);

                    canvasView.setmPathCurrent(mPath);
                    canvasView.setmPaintCurrent(mPaint);

                    //canvasView.setmPaint(new Path());
                    // canvasView.getmPaint().setColor(Color.rgb(red, green, blue));
                    dismiss();
                } else if(stickerView != null) {
                    Toast.makeText(activity, "PAINT WILL CHANGE", Toast.LENGTH_LONG).show();
                    stickerView.setBackgroundColor(Color.rgb(red, green, blue));
                    dismiss();
            }

            }
        });

        saveButton.setTextColor(Color.WHITE);
        saveButton.setBackgroundColor(Color.TRANSPARENT);

        red_SeekBar.setMax(255);
        red_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SB", "Onprogress!");
                redView.setText("" +seekBar.getProgress());
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
        green_SeekBar.setMax(255);
        green_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SB", "Onprogress!");
                greenView.setText("" +seekBar.getProgress());
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

        blue_SeekBar.setMax(255);
        blue_SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SB", "Onprogress!");
                blueView.setText("" +seekBar.getProgress());
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


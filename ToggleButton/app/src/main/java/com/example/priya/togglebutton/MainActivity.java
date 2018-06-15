package com.example.priya.togglebutton;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private TextView resultView;
    private ImageView imageView;
    private View backgroundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.peekABooTextView);
        toggleButton = findViewById(R.id.toggleButtonID);
        backgroundView = findViewById(R.id.backgroundView);
        toggleButton.setBackgroundColor(Color.WHITE);
        imageView = findViewById(R.id.imageView);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            ValueAnimator colorAnim;
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    colorAnim = ObjectAnimator.ofInt(backgroundView, "backgroundColor", Color.WHITE,Color.RED,Color.rgb(255, 165, 0), Color.YELLOW, Color.GREEN, Color.BLUE, Color.rgb(128,0,128), Color.BLACK);

                    colorAnim.setDuration(3500);
                    colorAnim.setEvaluator(new ArgbEvaluator());
                    colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                    colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                    colorAnim.start();
                //toggle is enabled
                resultView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.view_image);
                } else {
                //toggle is disabled
                    resultView.setVisibility(View.INVISIBLE);
                    imageView.setImageResource(R.drawable.hidden_image);
                    colorAnim.cancel();
                    backgroundView.setBackgroundColor(Color.WHITE);

                }
            }
        });
    }
}

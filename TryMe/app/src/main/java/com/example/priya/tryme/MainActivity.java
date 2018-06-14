package com.example.priya.tryme;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    View windowView;
    Button tryMeButton;
    EditText colorNameView;

    private int[] colors;
    private String[] color_Names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        colors = new int[]{Color.CYAN, Color.YELLOW,Color.RED, Color.GRAY, Color.GREEN, Color.WHITE, Color.BLACK, Color.BLUE, Color.MAGENTA, Color.LTGRAY, Color.rgb(255,67,0),
                Color.rgb(232,12,111), Color.rgb(4,12,111),Color.rgb(255,148,13),Color.rgb(233,181,111),
                Color.rgb(47,255,173), Color.rgb(255,124,11), Color.rgb(102,1,110), Color.rgb(48,0, 51),Color.rgb(255,255,0)};
        color_Names = new String[]{"CYAN","YELLOW","RED","GRAY","GREEN", "WHITE", "BLACK", "BLUE", "MAGENTA", "LIGHT GRAY", "ORANGE", "HOT PINK", "DARK BLUE",
                "GOLDEN YELLOW", "BEIGE", "MINT GREEN", "LIGHT ORANGE", "PURPLE", "DARK PURPLE", "YELLOW"};


        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        tryMeButton = findViewById(R.id.tryMeButton);
        windowView = findViewById(R.id.windowView);
        colorNameView = findViewById(R.id.colorNameView);


        tryMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorArrayLength = colors.length;
                Random rand = new Random();
                int randNum = rand.nextInt(colorArrayLength);
                windowView.setBackgroundColor(colors[randNum]);
                colorNameView.setVisibility(View.VISIBLE);
                if(randNum == 6 || randNum == 12 || randNum == 7 || randNum == 18) {
                    colorNameView.setTextColor(Color.WHITE);
                } else {
                    colorNameView.setTextColor(Color.BLACK);
                }
                colorNameView.setText(color_Names[randNum]);
                colorNameView.setFocusable(false);
                Log.d("Random",String.valueOf(randNum));
            }
        });
    }
}

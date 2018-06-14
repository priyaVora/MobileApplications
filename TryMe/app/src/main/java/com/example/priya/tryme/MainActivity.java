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
        colors = new int[]{Color.CYAN, Color.YELLOW,Color.RED, Color.GRAY, Color.GREEN};
        color_Names = new String[]{"CYAN","YELLOW","RED","GRAY","GREEN"};


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
                colorNameView.setText(color_Names[randNum]);
            }
        });
    }
}

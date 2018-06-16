package com.example.priya.petbio;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView catView;
    private ImageView dogView;
    private Button showButton;
    private TextView resultView;
    String selected_pet = null;
    private static final int REQUEST_CODE = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catView = findViewById(R.id.catViewID);
        dogView = findViewById(R.id.dogViewID);
        showButton = findViewById(R.id.showButton);
        resultView = findViewById(R.id.resultID);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected_pet!=null) {
                    Intent intent = new Intent(MainActivity.this, PetBioActivity.class);
                    if(selected_pet == "Cat") {
                        intent.putExtra("type", "Cat");
                        intent.putExtra("desc", "Cats are great pets to have!");
                    }else if(selected_pet == "Dog") {
                        intent.putExtra("type", "Dog");
                        intent.putExtra("desc", "Dogs are best pets to have!");
                    }
                    startActivityForResult(intent, REQUEST_CODE);
                } else {


                }
               // Intent intent = new Intent(MainActivity.this, PetBioActivity.class);

            }
        });

        resultView.setText("Please select a pet.");
        resultView.setTextColor(Color.RED);
        catView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText("User Selected: Cat");
                selected_pet = "Cat";
                resultView.setTextColor(Color.BLACK);
            }
        });

        dogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText("User Selected: Dog");
                selected_pet = "Dog";
                resultView.setTextColor(Color.BLACK);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String result = data.getStringExtra("returnData");
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}

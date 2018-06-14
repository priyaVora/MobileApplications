package com.example.priya.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroupID);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                radioButton = findViewById(checkedId);
                //find way to see which button has been selected
                switch (radioButton.getId()) {
                    case R.id.yesID: {
                        Log.d("RD","YES!!");
                    }
                    break;
                    case R.id.maybeID: {
                        Log.d("RD","MAYBE!!");
                    }
                    break;
                    case R.id.noID: {
                        Log.d("RD","NOPE!!");
                    }
                    break;  
                }
            }
        });
    }
}

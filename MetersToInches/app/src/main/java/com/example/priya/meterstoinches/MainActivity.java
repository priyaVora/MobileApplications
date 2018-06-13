package com.example.priya.meterstoinches;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    EditText enterMeters;
    Button convertButton;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        enterMeters = findViewById(R.id.metersValue);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTextView.setVisibility(View.VISIBLE);
                if (enterMeters.getText().toString().equals("")) {
                resultTextView.setText(R.string.error_message);
                resultTextView.setTextColor(Color.RED);
                } else {
                    double multiplier = 39.37;
                    double result = 0.0;
                    double meterValue = Double.parseDouble(enterMeters.getText().toString());
                    result = meterValue * multiplier;
                    //resultTextView.setText(Double.toString(result) + " inches");
                    resultTextView.setText(String.format("%.2f", result) + " inches");
                    resultTextView.setTextColor(Color.BLACK);

                }
            }
        });
    }
}

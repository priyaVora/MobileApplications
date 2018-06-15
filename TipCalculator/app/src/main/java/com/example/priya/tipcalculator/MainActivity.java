package com.example.priya.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enteredAmount;
    private SeekBar seekbar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textSeekBarView;
    private TextView totalBillView;

    private int seekbarPercentage = 0;
    private float enteredBillFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = findViewById(R.id.billAmountID);
        seekbar = findViewById(R.id.seekBar);
        calculateButton = findViewById(R.id.calculateButton);
        totalResultTextView = findViewById(R.id.resultID);
        textSeekBarView = findViewById(R.id.textSeekBarView);
        totalBillView = findViewById(R.id.totalBillView);

        Toast.makeText(MainActivity.this, "Calculate", Toast.LENGTH_LONG);
        calculateButton.setOnClickListener(this);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textSeekBarView.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = seekBar.getProgress();

            }
        });
    }
    @Override
    public void onClick(View view) {
        calculate();
    }

    public void calculate() {
        float result = 0.0f;

        if (!enteredAmount.getText().toString().equals("")) {
            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enteredBillFloat * seekbarPercentage/100;
            totalResultTextView.setText("Your tip will be: " + " $" +  String.valueOf(result));
            totalBillView.setText("Total bill: " + String.valueOf(enteredBillFloat + result));

        } else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }

    }
}

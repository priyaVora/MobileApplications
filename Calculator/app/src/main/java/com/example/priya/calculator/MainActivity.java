package com.example.priya.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView entryField;
    private TextView answerField;
    private Button openingParantheses;
    private Button closingParentheses;
    private Button backspace;
    private Button clear;
    private Button divide;
    private Button multiply;
    private Button subtract;
    private Button add;
    private Button dot;
    private Button equals;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;

    private String userCalculationInput = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setControls();
        setActionListener();

    }

    public void setActionListener() {
        openingParantheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "(";
                entryField.setText(userCalculationInput);
            }
        });

        closingParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= ")";
                entryField.setText(userCalculationInput);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput= "";
                entryField.setText(userCalculationInput);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "/";
                entryField.setText(userCalculationInput);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "*";
                entryField.setText(userCalculationInput);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput = "-";
                entryField.setText(userCalculationInput);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "+";
                entryField.setText(userCalculationInput);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= ".";
                entryField.setText(userCalculationInput);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userCalculationInput+= "0";
                        entryField.setText(userCalculationInput);
                    }
                });
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "1";
                entryField.setText(userCalculationInput);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "2";
                entryField.setText(userCalculationInput);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "3";
                entryField.setText(userCalculationInput);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "4";
                entryField.setText(userCalculationInput);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "5";
                entryField.setText(userCalculationInput);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "6";
                entryField.setText(userCalculationInput);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "7";
                entryField.setText(userCalculationInput);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "8";
                entryField.setText(userCalculationInput);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "9";
                entryField.setText(userCalculationInput);
            }
        });
    }

    public void setControls() {
        entryField = findViewById(R.id.entryField);
        answerField = findViewById(R.id.answerField);
        openingParantheses = findViewById(R.id.opening_parantheses);
        closingParentheses = findViewById(R.id.closing_parantheses);
        backspace = findViewById(R.id.backspace_button);
        clear = findViewById(R.id.clear_button);
        divide = findViewById(R.id.divide_button);
        multiply = findViewById(R.id.multiply_button);
        subtract = findViewById(R.id.subtract_button);
        add = findViewById(R.id.add_button);
        dot = findViewById(R.id.period);
        equals = findViewById(R.id.equal_Button);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.zero_button);
    }


}

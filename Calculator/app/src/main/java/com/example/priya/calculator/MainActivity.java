package com.example.priya.calculator;

import android.graphics.Color;
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
    private Button previousSelectedButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setControls();
        setActionListener();

    }
    public void setHighlightOnButton() {
        if (previousSelectedButton != null) {
            previousSelectedButton.setBackgroundResource(R.drawable.button_highlight);
            previousSelectedButton.setTextColor(Color.rgb(10, 92, 99));
        }
    }

    public void removeHighlight() {
        if(previousSelectedButton != null) {
            previousSelectedButton.setBackgroundResource(R.drawable.button_shape);
            previousSelectedButton.setTextColor(Color.WHITE);
        }
    }
    public void setActionListener() {
        openingParantheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "(";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = openingParantheses;
                setHighlightOnButton();
            }
        });

        closingParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= ")";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = closingParentheses;
                setHighlightOnButton();
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput = userCalculationInput.substring(0, userCalculationInput.length() - 1);
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = backspace;
                setHighlightOnButton();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput= "";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = clear;
                setHighlightOnButton();
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "/";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = divide;
                setHighlightOnButton();
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "*";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = multiply;
                setHighlightOnButton();
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput = "-";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = subtract;
                setHighlightOnButton();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "+";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = add;
                setHighlightOnButton();
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= ".";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = dot;
                setHighlightOnButton();
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
                        removeHighlight();
                        previousSelectedButton = zero;
                        setHighlightOnButton();
                    }
                });
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "1";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = one;
                setHighlightOnButton();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "2";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = two;
                setHighlightOnButton();
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "3";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = three;
                setHighlightOnButton();
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "4";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = four;
                setHighlightOnButton();
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "5";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = five;
                setHighlightOnButton();
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "6";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = six;
                setHighlightOnButton();
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "7";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = seven;
                setHighlightOnButton();
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "8";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = eight;
                setHighlightOnButton();
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput+= "9";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = nine;
                setHighlightOnButton();
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeHighlight();
                previousSelectedButton = null;
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

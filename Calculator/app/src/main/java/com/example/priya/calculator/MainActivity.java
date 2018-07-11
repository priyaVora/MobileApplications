package com.example.priya.calculator;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;

import bsh.EvalError;
import bsh.Interpreter;


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

    ArrayList<String> userInputArray = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        userInputArray = new ArrayList<String>();
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
                userInputArray.add("(");
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
                userInputArray.add(")");
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
                userInputArray.add("/");
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
                userInputArray.add("*");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCalculationInput += "-";
                entryField.setText(userCalculationInput);
                removeHighlight();
                previousSelectedButton = subtract;
                setHighlightOnButton();
                userInputArray.add("-");
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
                userInputArray.add("+");
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
                userInputArray.add(".");
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
                        userInputArray.add("0");
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
                userInputArray.add("1");
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
                userInputArray.add("2");
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
                userInputArray.add("3");
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
                userInputArray.add("4");
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
                userInputArray.add("5");
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
                userInputArray.add("6");
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
                userInputArray.add("7");
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
                userInputArray.add("8");
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
                userInputArray.add("9");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeHighlight();
                previousSelectedButton = equals;
                setHighlightOnButton();
                try {
                    answerField.setTextColor(Color.WHITE);
                    calculate();
                } catch (EvalError evalError) {
                    evalError.printStackTrace();
                    Toast.makeText(MainActivity.this, "Invalid Input!", Toast.LENGTH_LONG).show();
                    answerField.setText("INVALID CALCULATION: Please enter a valid calculation above.");
                    answerField.setTextColor(Color.RED);
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       equals.setBackgroundResource(R.drawable.button_shape);
                       equals.setTextColor(Color.WHITE);

                    }
                }, 1000);

                previousSelectedButton= null;

            }
        });
    }

    public void calculate() throws EvalError {
        Interpreter interpreter = new Interpreter();
        interpreter.eval("result = " + entryField.getText());
        answerField.setText(interpreter.get("result").toString());
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

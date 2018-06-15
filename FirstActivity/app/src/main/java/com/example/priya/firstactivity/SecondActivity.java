package com.example.priya.firstactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {


    private TextView showMessage;
    private Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_second);

        showMessage = findViewById(R.id.messageTextViewID);
        goBack = findViewById(R.id.goBackButtonID);
        Bundle extras = getIntent().getExtras();
        //check

        if(extras != null) {
            String message = extras.getString("Message");
            int myInt = extras.getInt("Value");

            showMessage.setText("Message is " + message + " and: " + String.valueOf(myInt));
        }

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","From Second Activity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}

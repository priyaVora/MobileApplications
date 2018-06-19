package com.example.priya.sharedp;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TextView resultView;
    private Button saveButton;
    private EditText enteredMessage;

    private static final String PREFS_NAME = "myPrefsFile";

    private SharedPreferences myPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    public void setUI() {
        resultView = findViewById(R.id.resultTextView);
        saveButton = findViewById(R.id.saveButton);
        enteredMessage = findViewById(R.id.enteredName);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();

                editor.putString("Message",enteredMessage.getText().toString());
                editor.commit();

            }
        });

        //get data back

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        if(prefs.contains("Message")) {
            String message = prefs.getString("Message","not found");
            resultView.setText("Message: " + message);
        }
    }
}

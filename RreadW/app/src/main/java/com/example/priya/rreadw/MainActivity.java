package com.example.priya.rreadw;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText enteredMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.saveButton);
        enteredMessage = findViewById(R.id.editText);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            if(enteredMessage.getText().toString().equals("")) {
                String message = enteredMessage.getText().toString();
                writeToFile(message);
                }
            }
        });

        try {
            if(readFromFile() != null) {
            enteredMessage.setText(readFromFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeToFile(String message)  {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("todolist.txt", Context.MODE_PRIVATE));
            writer.write(message);
            writer.close(); // always close your streams
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile() throws IOException {
        String result = "";
        InputStream inputStream = openFileInput("todolist.txt");

        if(inputStream != null) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader buffReader = new BufferedReader(reader);

            String tempString = "";

            StringBuilder stringBuilder = new StringBuilder();

            while((tempString = buffReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }

            inputStream.close();
            result = stringBuilder.toString();
        }
        return result;
    }
}

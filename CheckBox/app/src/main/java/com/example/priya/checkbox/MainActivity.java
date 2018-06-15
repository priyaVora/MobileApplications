package com.example.priya.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private CheckBox momCheckBox;
    private CheckBox dadCheckBox;
    private CheckBox grandpaCheckBox;
    private Button showButton;
    private TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        momCheckBox = findViewById(R.id.momCheckBoxID);
        dadCheckBox = findViewById(R.id.dadCheckBoxID);
        grandpaCheckBox = findViewById(R.id.grandpaCheckBoxID);

        showButton = findViewById(R.id.showButtonID);
        showTextView = findViewById(R.id.resultID);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(momCheckBox.getText().toString() + " status is: " + momCheckBox.isChecked() + "\n");
                stringBuilder.append(dadCheckBox.getText().toString() + " status is: " + dadCheckBox.isChecked() + "\n");
                stringBuilder.append(grandpaCheckBox.getText().toString() + " status is: " + grandpaCheckBox.isChecked() + "\n");

                showTextView.setText(stringBuilder);
            }
        });
    }
}

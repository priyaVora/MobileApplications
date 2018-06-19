package com.example.priya.recyclev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView name, description;

    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras = getIntent().getExtras();
        name = findViewById(R.id.dNameID);
        description = findViewById(R.id.dDescriptioID);

        if(extras != null) {
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }
    }
}

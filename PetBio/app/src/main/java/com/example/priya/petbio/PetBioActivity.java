package com.example.priya.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class PetBioActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText title;
    private ImageView petView;
    private TextView petDesc;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_bio);
        title = findViewById(R.id.titleBar);
        petView = findViewById(R.id.petViewID);
        petDesc = findViewById(R.id.petDescID);
        backButton = findViewById(R.id.goBackButtonID);


        backButton.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        String description = extras.getString("desc");
        petDesc.setText(description);

        String type = extras.getString("type").trim();

        if(type.equals("Cat")) {
            petView.setImageResource(R.drawable.cat);
        } else if(type.equals("Dog")) {
            petView.setImageResource(R.drawable.dog);
        }
    }


    @Override
    public void onClick(View view) {
        Intent returnIntent = getIntent();
        Bundle extras = returnIntent.getExtras();
        String type = extras.getString("type");
        returnIntent.putExtra("returnData",type);
        petDesc.setText(petDesc.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}

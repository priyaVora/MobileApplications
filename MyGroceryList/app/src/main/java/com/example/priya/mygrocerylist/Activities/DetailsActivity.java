package com.example.priya.mygrocerylist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import com.example.priya.mygrocerylist.R;


public class DetailsActivity extends AppCompatActivity {
    private TextView itemNameView;
    private TextView itemQuantityView;
    private TextView itemDate;

    private Button editButton;
    private Button deleteButton;

    private int groceryId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        itemNameView = findViewById(R.id.itemNameDet);
        itemQuantityView = findViewById(R.id.quantityDet);
        itemDate = findViewById(R.id.dateAddedDet);
        editButton = findViewById(R.id.editButtonDet);
        deleteButton = findViewById(R.id.deleteButtonDet);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            itemNameView.setText(bundle.getString("name"));
            itemQuantityView.setText(bundle.getString("quantity"));
            itemDate.setText(bundle.getString("date"));

            groceryId = bundle.getInt("id");
        }
    }
}

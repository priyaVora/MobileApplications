package com.example.priya.mygrocerylist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.priya.mygrocerylist.Data.DatabaseHandler;
import com.example.priya.mygrocerylist.Model.Grocery;
import com.example.priya.mygrocerylist.R;
import com.example.priya.mygrocerylist.UI.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class GroceryListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Grocery> groceryList;
    private List<Grocery> listItems;
    private DatabaseHandler db;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText groceryItem;
    private EditText quantity;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My Grocery");

        setSupportActionBar(toolbar);

        db = new DatabaseHandler(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUpDialog();
                updateListOnView(db);
            }
        });
        
        recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        groceryList = new ArrayList<>();


        updateListOnView(db);
    }


    public void updateListOnView(DatabaseHandler db) {
        //Get items from database
        groceryList = db.getAllGroceries();
        listItems = new ArrayList<>();
        for (Grocery c : groceryList) {
            Grocery grocery = new Grocery();
            grocery.setName(c.getName());
            grocery.setQuantity("Qty: " + c.getQuantity());
            grocery.setId(c.getId());
            grocery.setDateItemAdded("Add on: " + c.getDateItemAdded());

            listItems.add(grocery);
        }
        recyclerViewAdapter = new RecyclerViewAdapter(this,listItems);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();
    }


    private void createPopUpDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.pop_up, null);
        groceryItem = view.findViewById(R.id.groceryItem);
        quantity = view.findViewById(R.id.groceryQty);
        saveButton = view.findViewById(R.id.saveButton);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:save to database
                //TODO:Go to Next Screen

                if (!groceryItem.getText().toString().isEmpty() && !quantity.getText().toString().isEmpty()) {
                    saveGroceryTODB(view);
                }
            }
        });


    }

    private void saveGroceryTODB(View view) {
        Grocery grocery = new Grocery();
        String newGrocery = groceryItem.getText().toString();
        String newGroceryQuantity = quantity.getText().toString();

        grocery.setId(db.getGroceriesCount()+1);
        grocery.setName(newGrocery);
        grocery.setQuantity(newGroceryQuantity);
        grocery.setDateItemAdded(System.currentTimeMillis()+"");

        //Save to DB
        db.addGrocery(grocery);
        Snackbar.make(view, "Item Saved!", Snackbar.LENGTH_LONG).show();
        Toast.makeText(this, "Item Added ID: " + String.valueOf(db.getGroceriesCount()), Toast.LENGTH_LONG).show();

        Log.d("Item Added: +", String.valueOf(db.getGroceriesCount()));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                //Start a new activity
                startActivity(new Intent(GroceryListActivity.this, GroceryListActivity.class));
            }
        }, 1000); // 1 second
    }


}

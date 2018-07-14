package com.example.priya.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;
import Model.Operation;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);




        LinearLayoutManager layoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManger);
        String[] operationsList = {"Color", "Brush","Upload", "Clear", "Add+ 1", "Add+ 2", "Add+3"
        ,"Add+ 4", "Add+ 5"};

        listItems = new ArrayList<>();

        for(int i = 0; i< operationsList.length;i++) {
            ListItem item = new ListItem(
                    operationsList[i], R.drawable.colorchange
            );

            listItems.add(item);
        }

        adapter = new MyAdapter(this, listItems);

        recyclerView.setAdapter(adapter);
    }
}

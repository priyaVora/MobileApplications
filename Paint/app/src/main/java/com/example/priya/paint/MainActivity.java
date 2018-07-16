package com.example.priya.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerViewId);
        canvasView = findViewById(R.id.signature_canvas);
        recyclerView.setHasFixedSize(true);




        LinearLayoutManager layoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManger);
        String[] operationsList = {"Color", "Brush","Upload", "Clear", "Erase", "Text", "Paint Fill"
        ,"Shapes", "Stickers"};

        listItems = new ArrayList<>();

        for(int i = 0; i< operationsList.length;i++) {
            ListItem item = new ListItem(
                    operationsList[i], R.drawable.colorchange
            );

            listItems.add(item);
        }

        adapter = new MyAdapter(this, listItems, canvasView);

        recyclerView.setAdapter(adapter);
    }
}

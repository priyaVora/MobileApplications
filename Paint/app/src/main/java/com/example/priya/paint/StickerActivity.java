package com.example.priya.paint;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;

import com.xiaopo.flying.sticker.StickerView;
import com.xiaopo.flying.sticker.TextSticker;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Adapter.MyStickerAdapter;
import Model.ListItem;
import Model.StickerItem;

public class StickerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<StickerItem> stickerItemList;

    StickerView stickerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_sticker);
        stickerView = findViewById(R.id.stickerView);

        //add text sticker
        TextSticker sticker = new TextSticker(this);
        sticker.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sticker_transparent_background));
        sticker.setTextColor(Color.BLACK);
        sticker.setText("Captain America");
        sticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        sticker.resizeText();

        stickerView.addSticker(sticker);


        recyclerView = findViewById(R.id.recyclerViewId_sticker);
        recyclerView.setHasFixedSize(true);




        LinearLayoutManager layoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManger);
        String[] operationsList = {"Go Back", "Add Text", "Clear", "Paint Fill", "Save"};

        stickerItemList = new ArrayList<>();

        for(int i = 0; i< operationsList.length;i++) {
            StickerItem item = new StickerItem(
                    operationsList[i], R.drawable.colorchange
            );

            stickerItemList.add(item);
        }

        adapter = new MyStickerAdapter(this, stickerItemList,stickerView);

        recyclerView.setAdapter(adapter);

    }
}

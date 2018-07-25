package com.example.priya.stickerview;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;

import com.xiaopo.flying.sticker.Sticker;
import com.xiaopo.flying.sticker.StickerView;
import com.xiaopo.flying.sticker.TextSticker;

public class MainActivity extends AppCompatActivity {

    StickerView stickerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stickerView = findViewById(R.id.stickerView);

        //add text sticker
        TextSticker sticker = new TextSticker(this);
        sticker.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sticker_transparent_background));
        sticker.setTextColor(Color.WHITE);
        sticker.setText("Captain America");
        sticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        sticker.resizeText();

        stickerView.addSticker(sticker);
    }
}

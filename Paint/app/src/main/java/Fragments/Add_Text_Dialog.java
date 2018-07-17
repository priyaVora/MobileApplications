package Fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.priya.paint.R;
import com.xiaopo.flying.sticker.Sticker;
import com.xiaopo.flying.sticker.StickerView;
import com.xiaopo.flying.sticker.TextSticker;

import android.widget.Button;

/**
 * Created by Priya on 7/17/2018.
 */

public class Add_Text_Dialog extends Dialog implements View.OnClickListener{
    private EditText editText;
    private Button addText;
    Context context;
    StickerView stickerView;

    public Add_Text_Dialog(Context context, StickerView stickerView) {
        super(context);
        this.context = context;
        this.stickerView = stickerView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_text_dialog);

        editText = findViewById(R.id.stickerText);
        addText = findViewById(R.id.saveStickerText);

        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextSticker sticker = new TextSticker(context);
                sticker.setDrawable(ContextCompat.getDrawable(context, R.drawable.sticker_transparent_background));
                sticker.setTextColor(Color.BLACK);
                sticker.setMaxTextSize(65);
                sticker.setText(editText.getText().toString());
                sticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
                sticker.resizeText();

                stickerView.addSticker(sticker);
                dismiss();
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
}

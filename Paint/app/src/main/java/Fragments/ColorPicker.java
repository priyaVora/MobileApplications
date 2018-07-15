package Fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.R;

import java.util.ArrayList;
import java.util.List;

import Model.ColorItem;

/**
 * Created by Priya on 7/14/2018.
 */
public class ColorPicker extends Dialog implements View.OnClickListener{

    public Context activity;
    public CanvasView canvasView;
    public Dialog dialog;
    

    public ColorPicker(Context activity, CanvasView canvasView) {
        super(activity);
        this.activity = activity;
        this.canvasView = canvasView;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.color_change_dialog);

    }

    @Override
    public void onClick(View view) {

    }
}


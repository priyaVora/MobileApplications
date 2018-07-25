package com.example.shapesdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tom on 2/7/2017.
 */

public class DrawView extends View {
    Paint myRedPaintFill;
    Paint myGreenPaintStroke;
    Path myPath;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        myRedPaintFill = new Paint();
        myRedPaintFill.setColor(Color.RED);
        myRedPaintFill.setStyle(Paint.Style.FILL);

        myGreenPaintStroke = new Paint();
        myGreenPaintStroke.setColor(0xff337722); // aarrggbb alpha is first
        myGreenPaintStroke.setStyle(Paint.Style.STROKE);
        myGreenPaintStroke.setStrokeWidth(10);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, 0, 200, 200, myGreenPaintStroke);
        canvas.drawCircle(100, 300, 40, myRedPaintFill);
        canvas.drawRect(200,300, 250, 350, myGreenPaintStroke);
        

        myPath = new Path();
        myPath.moveTo(400,400);
        myPath.lineTo(500,600);
        myPath.lineTo(300,600);
        canvas.drawPath(myPath, myRedPaintFill);

    }

}

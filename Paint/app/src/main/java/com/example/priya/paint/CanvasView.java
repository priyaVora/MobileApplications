package com.example.priya.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Priya on 7/13/2018.
 */

public class CanvasView extends View {

    public int width;
    public int height;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    Context context;
    private Paint mPaint;
    private float mX, mY;
    private static final float TOLERANCE = 5;

    private Path mPathCurrent;
    private Paint mPaintCurrent;


    List<Path> pathList = new ArrayList<Path>();
    List<Paint> mPaintList = new ArrayList<Paint>();


    public CanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);

        mPathCurrent = mPath;
        mPaintCurrent = mPaint;

        addPaint(mPaint);
        addPath(mPath);
    }

    public void addPaint(Paint mPaint) {
        if(!(mPaintList.contains(mPaint))) {
            mPaintList.add(mPaint);
            mPaintCurrent = mPaint;
        }
    }

    public void addPath(Path mPath) {
        if(!(pathList.contains(mPath))) {
            pathList.add(mPath);
            mPathCurrent = mPath;
        }
    }

    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw the mPath with the mPaint on the canvas when onDraw
      //  canvas.drawPath(mPath, mPaint);

        int count = 0;
        for (Path path : pathList) {
            canvas.drawPath(path, mPaintList.get(count));
            count++;
        }
//        canvas.drawPath(mPathCurrent, mPaintCurrent);
    }

    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        mPathCurrent.moveTo(x, y);
        //mPathCurrent.moveTo(x,y);
        mX = x;
        mY = y;
        pathList.add(mPathCurrent);
        mPaintList.add(mPaintCurrent);
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
            mPathCurrent.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
        //mPathCurrent.lineTo(mX, mY);
    }

    public void clearCanvas() {
        for (Path each_path: pathList) {
                each_path.reset();
            invalidate();
        }
        resetToDefaultBrush();
    }

    public void resetToDefaultBrush() {
        pathList.clear();
        mPaintList.clear();
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);

        mPathCurrent = mPath;
        mPaintCurrent = mPaint;

        addPaint(mPaint);
        addPath(mPath);
    }

    // when ACTION_UP stop touch
    private void upTouch() {
        mPath.lineTo(mX, mY);
    }

    //override the onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }

    public Path getmPath() {
        return mPath;
    }

    public void toast() {
        Toast.makeText(context,"Hello", Toast.LENGTH_LONG);
    }
    public void setmPath(Path mPath) {
        this.mPath = mPath;
    }

    public Paint getmPaint() {
        return mPaint;
    }

    public void setmPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }

    public Path getmPathCurrent() {
        return mPathCurrent;
    }

    public void setmPathCurrent(Path mPathCurrent) {
        this.mPathCurrent = mPathCurrent;
    }


    public Paint getmPaintCurrent() {
        return mPaintCurrent;
    }

    public void setmPaintCurrent(Paint mPaintCurrent) {
        this.mPaintCurrent = mPaintCurrent;
    }
}
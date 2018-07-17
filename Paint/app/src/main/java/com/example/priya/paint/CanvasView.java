package com.example.priya.paint;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AlertDialog;
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
        this.setBackgroundColor(Color.WHITE);

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


        Paint mPaint2 = new Paint();
        Path mPath2 = new Path();

        mPaint2.setAntiAlias(true);
        mPaint2.setColor(Color.BLACK);
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeJoin(Paint.Join.ROUND);
        mPaint2.setStrokeWidth(4f);

        addPaint(mPaint2);
        addPath(mPath2);
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
        if(!pathList.isEmpty()) {
            for (Path path : pathList) {
                if(count > 0) {
                    canvas.drawPath(path, mPaintList.get(count));
                }
                count++;
            }
        } else {

            alertDialog();
        }

//        canvas.drawPath(mPathCurrent, mPaintCurrent);
    }


    public void alertDialog() {
        AlertDialog.Builder alertDialog;


        alertDialog =  new AlertDialog.Builder(context, R.style.AlertDialogStyle);


        //set things up - setup title
        alertDialog.setTitle(R.string.alert_title);
        alertDialog.setIcon(android.R.drawable.star_big_on);

        //set message
        alertDialog.setMessage(R.string.message);
        //set cancelable
        alertDialog.setCancelable(false);

        //set positive button
//        alertDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                //Exit our window activity
//                this.clearCanvas();
//            }
//        });

        alertDialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Exit our window activity
                dialog.cancel();
            }
        });

        //create the actual dialog
        AlertDialog dialog = alertDialog.create();

        //show the dialog
        alertDialog.show();
    }






    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        mPathCurrent.moveTo(x, y);
        //mPathCurrent.moveTo(x,y);
        mX = x;
        mY = y;
        if(!pathList.contains(mPathCurrent)) {
            pathList.add(mPathCurrent);
            mPaintList.add(mPaintCurrent);
        }

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
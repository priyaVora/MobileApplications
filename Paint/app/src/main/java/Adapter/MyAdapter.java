package Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import Fragments.Brush_Size_Change_Dialog;
import Fragments.ColorPicker;
import Model.ListItem;


/**
 * Created by Priya on 7/14/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    public CanvasView canvasView;
    private List<ListItem> listItems;
    Paint mPaint;



    public MyAdapter(Context context, List listItems, CanvasView canvasView) {
        this.context = context;
        this.listItems = listItems;
        this.canvasView = canvasView;
    }




    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.title.setText(item.getSpecificTitle(position));
        holder.operationImgView.setImageResource(item.getSpecificPhotoId(position));
       // holder.operationImgView.setImageResource(R.drawable.colorchange);
         //holder.operationImgView.setImageResource(item.getOperationsList()[position].getPhotoId());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        CanvasView canvas_View;
        public ImageView operationImgView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
                canvas_View = canvasView;
            title = itemView.findViewById(R.id.operation_title);
            operationImgView = itemView.findViewById(R.id.opereation_ImageView);
        }

        @Override
        public void onClick(View view) {
            //Get position of the row clicked or tapped.
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);

            if(item.getTitle().equals("Clear")) {
                if(canvasView != null) {
                    alertDialog();
                }
            } else if(item.getTitle().equals("Color")) {
                ColorPicker cd = new ColorPicker(context, canvasView);
                cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.setCancelable(false);
                cd.show();
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Brush")) {

                Brush_Size_Change_Dialog cd = new Brush_Size_Change_Dialog(context, canvasView);
                cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.setCancelable(false);
                cd.show();

                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Upload")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Clear")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Erase")) {
                Path mPath;
                Paint mPaint;

                mPath = new Path();

                // and we set a new Paint with the desired attributes
                mPaint = new Paint();
                mPaint.setAntiAlias(true);
                mPaint.setColor(Color.rgb(255, 255, 255));
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setStrokeJoin(Paint.Join.ROUND);
                mPaint.setStrokeWidth(canvasView.getmPaint().getStrokeWidth());
                canvasView.addPath(mPath);
                canvasView.addPaint(mPaint);
                canvasView.setmPaint(mPaint);

                canvasView.setmPathCurrent(mPath);
                canvasView.setmPaintCurrent(mPaint);

                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();

            } else if(item.getTitle().equals("Save")) {
//                Bitmap bitmap;
//
//                canvasView.setDrawingCacheEnabled(true);
//                bitmap = Bitmap.createBitmap(canvasView.getDrawingCache());
//                canvasView.setDrawingCacheEnabled(false);
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
//                try {
//                    canvasView.setDrawingCacheEnabled(true);
//                    Bitmap bitmap = canvasView.getDrawingCache();
//                    File f = null;
//                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//                        File file = new File(Environment.getExternalStorageDirectory(), "TTImages_cache");
//                        if (!file.exists()) {
//                            file.mkdirs();
//                        }
//                        f = new File(file.getAbsolutePath() + file.separator + "filename" + ".png");
//                    }
//                    FileOutputStream ostream = new FileOutputStream(f);
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
//                    ostream.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Bitmap b = null;

//create directory if not exist
//                File rootsd = Environment.getExternalStorageDirectory();
//                File dcim = new File(rootsd.getAbsolutePath() + "/DCIM");
//                File dir = new File(dcim.getPath());
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//
//                File output = new File(dir, "tempfile.jpg");
//                OutputStream os = null;
//
//                try {
//                    os = new FileOutputStream(output);
//                    b.compress(Bitmap.CompressFormat.JPEG, 100, os);
//                    os.flush();
//                    os.close();
//
//                    //this code will scan the image so that it will appear in your gallery when you open next time
//                    MediaScannerConnection.scanFile(canvasView.getContext(), new String[] { output.toString() }, null,
//                            new MediaScannerConnection.OnScanCompletedListener() {
//                                public void onScanCompleted(String path, Uri uri) {
//                                   // Log.d("appname", "image is saved in gallery and gallery is refreshed.");
//                                }
//                            }
//                    );
//                } catch (Exception e) {
//                }

                //String fileName = String.valueOf("PAINT_SAVED_IMAGE");
// generate the image path
               // String imagePath = Environment.getExternalStorageDirectory().toString() + File.separator +  fileName + ".png";

//                try {
//
//                    // save the image as png
//                    FileOutputStream out = new FileOutputStream(imagePath);
//                    // compress the image to png and pass it to the output stream
//                    loadBitmapFromView(view).compress(Bitmap.CompressFormat.PNG, 90, out);
//
//                    // save the image
//                    out.flush();
//                    out.close();
//                    Toast.makeText(context, "NO Error saving image", Toast.LENGTH_LONG);
//                } catch (Exception error) {
//                    Toast.makeText(context, "Error saving image", Toast.LENGTH_LONG);
//                    //Log.e("Error saving image", error.getMessage());
//                }
//                canvasView.setDrawingCacheEnabled(true);
//                String imgSaved = MediaStore.Images.Media.insertImage(
//                        context.getContentResolver(), canvasView.getDrawingCache(),
//                        UUID.randomUUID().toString()+".png", "drawing");
//                if(imgSaved!=null){
//                    Toast savedToast = Toast.makeText(context,
//                            "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
//                    savedToast.show();
//                }
//                else{
//                    Toast unsavedToast = Toast.makeText(context,
//                            "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
//                    unsavedToast.show();
//                }
//                canvasView.destroyDrawingCache();



                Toast unsavedToast1 = Toast.makeText(context,
                        "Before Try Catch", Toast.LENGTH_SHORT);
                /////////////////////
                try {
                    canvas_View.setDrawingCacheEnabled(true);

                    Bitmap bitmap = canvasView.getDrawingCache();
                    Canvas canvas = new Canvas();
                    canvas.drawColor(Color.WHITE);
                    canvas.drawBitmap(bitmap, 0, 0, null);


                    File f = null;
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                        File file = new File(Environment.getExternalStorageDirectory(),"DCIM/Screenshots");
                        if(!file.exists()){
                            file.mkdirs();
                        }
                        f = new File(file.getAbsolutePath()+file.separator+ "saved_canvas"+".jpg");
                    }
                    FileOutputStream ostream = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
                    ostream.close();
                    Toast unsavedToast = Toast.makeText(context,
                            "Image could be saved.", Toast.LENGTH_SHORT);
                    unsavedToast.show();
                } catch(Exception e){
                    Toast unsavedToast = Toast.makeText(context,
                            "Oops!!! Image could not be saved." + e.toString(), Toast.LENGTH_SHORT);
                    unsavedToast.show();
                    e.printStackTrace();
                }




            }
        }
    }

    private static String getGalleryPath() {
        return Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DCIM + "/Camera";
    }
    public static Bitmap loadBitmapFromView(View view) {

        // width measure spec
        int widthSpec = View.MeasureSpec.makeMeasureSpec(
                view.getMeasuredWidth(), View.MeasureSpec.AT_MOST);
        // height measure spec
        int heightSpec = View.MeasureSpec.makeMeasureSpec(
                view.getMeasuredHeight(), View.MeasureSpec.AT_MOST);
        // measure the view
        view.measure(widthSpec, heightSpec);
        // set the layout sizes
        view.layout(view.getLeft(), view.getTop(), view.getMeasuredWidth() + view.getLeft(), view.getMeasuredHeight() + view.getTop());
        // create the bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        // create a canvas used to get the view's image and draw it on the bitmap
        Canvas c = new Canvas(bitmap);
        // position the image inside the canvas
        c.translate(-view.getScrollX(), -view.getScrollY());
        // get the canvas
        view.draw(c);

        return bitmap;
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
        alertDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Exit our window activity
                canvasView.clearCanvas();
            }
        });

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



    public Paint getmPaint() {
        return mPaint;
    }

    public void setmPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }
}

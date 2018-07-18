package Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.MainActivity;
import com.example.priya.paint.R;
import com.example.priya.paint.StickerActivity;
import com.xiaopo.flying.sticker.Sticker;
import com.xiaopo.flying.sticker.StickerView;
import com.xiaopo.flying.sticker.TextSticker;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import Fragments.Add_Text_Dialog;
import Fragments.ColorPicker;
import Model.ListItem;
import Model.StickerItem;

/**
 * Created by Priya on 7/17/2018.
 */

public class MyStickerAdapter extends  RecyclerView.Adapter<MyStickerAdapter.ViewHolder> {
    private Context context;
    private List<StickerItem> listItems;
    StickerView stickerView;
    Paint mPaint;

    public MyStickerAdapter(Context context, List listItems, StickerView stickerView) {
        this.context = context;
        this.listItems = listItems;
        this.stickerView = stickerView;
    }


    @Override
    public MyStickerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyStickerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StickerItem item = listItems.get(position);
        holder.title.setText(item.getSpecificTitle(position));
        holder.operationImgView.setImageResource(item.getSpecificPhotoId(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title;
        public ImageView operationImgView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.operation_title);
            operationImgView = itemView.findViewById(R.id.opereation_ImageView);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            StickerItem item = listItems.get(position);
            Toast.makeText(context, item.getTitle(),Toast.LENGTH_LONG).show();
            if(item.getTitle().equals("Clear")) {
                Intent intent = new Intent(context, StickerActivity.class);
                view.getContext().startActivity(intent);
            } else if(item.getTitle().equals("Go Back")) {
                Intent intent = new Intent(context, MainActivity.class);
                view.getContext().startActivity(intent);
            } else if(item.getTitle().equals("Paint Fill")) {
                ColorPicker cd = new ColorPicker(context, stickerView);
                cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.setCancelable(false);
                cd.show();
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Save")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();

                try {
                    stickerView.setDrawingCacheEnabled(true);

                    Bitmap bitmap = stickerView.getDrawingCache();
                    Canvas canvas = new Canvas();
                    canvas.drawColor(Color.WHITE);
                    canvas.drawBitmap(bitmap, 0, 0, null);


                    File f = null;
                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                        File file = new File(Environment.getExternalStorageDirectory(),"DCIM/Screenshots");
                        if(!file.exists()){
                            file.mkdirs();
                        }
                        f = new File(file.getAbsolutePath()+file.separator+ "text_save"+".jpg");
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
                Toast.makeText(context, "Save should happen", Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Add Text")) {
                Add_Text_Dialog cd = new Add_Text_Dialog(context, stickerView);
                cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.setCancelable(false);
                cd.show();
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();

            }
        }
    }

}



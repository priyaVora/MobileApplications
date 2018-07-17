package Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.R;
import com.example.priya.paint.StickerActivity;
import com.xiaopo.flying.sticker.Sticker;
import com.xiaopo.flying.sticker.StickerView;

import java.util.List;

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
            Toast.makeText(context, "Clicked",Toast.LENGTH_LONG).show();
            if(item.getTitle().equals("Text")) {
                Intent intent = new Intent(context, StickerActivity.class);
                view.getContext().startActivity(intent);

            }
        }
    }
}



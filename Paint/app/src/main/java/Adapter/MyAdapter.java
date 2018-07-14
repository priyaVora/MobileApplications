package Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.priya.paint.CanvasView;
import com.example.priya.paint.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by Priya on 7/14/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    public CanvasView canvasView;
    private List<ListItem> listItems;

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
                if(canvasView == null) {
                    Toast.makeText(context, "Canvas is null", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Canvas is not null", Toast.LENGTH_LONG).show();
                    canvasView.clearCanvas();
                }
            } else if(item.getTitle().equals("Color")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Brush")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Upload")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Clear")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else {

            }
        }
    }
}

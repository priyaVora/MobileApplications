package Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
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
import com.example.priya.paint.MainActivity;
import com.example.priya.paint.R;

import java.util.List;

import Fragments.Custom_Dialog;
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
                if(canvasView != null) {
                    AlertDialog.Builder alertDialog;

                    alertDialog =  new AlertDialog.Builder(context);

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
            } else if(item.getTitle().equals("Color")) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
            } else if(item.getTitle().equals("Brush")) {

                Custom_Dialog cd = new Custom_Dialog(context);
                cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.setCancelable(false);
                cd.show();




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

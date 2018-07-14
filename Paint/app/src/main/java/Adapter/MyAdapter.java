package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.example.priya.paint.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by Priya on 7/14/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listItems) {
        this.context = context;
        this.listItems = listItems;
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView operationImgView;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.operation_title);
          operationImgView = itemView.findViewById(R.id.opereation_ImageView);
        }
    }
}

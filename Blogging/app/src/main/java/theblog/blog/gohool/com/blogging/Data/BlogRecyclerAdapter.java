package theblog.blog.gohool.com.blogging.Data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import theblog.blog.gohool.com.blogging.Model.Blog;
import theblog.blog.gohool.com.blogging.R;

/**
 * Created by Priya on 8/8/2018.
 */

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {
    Context context;
    List<Blog> blogList;

    public BlogRecyclerAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent, false);
         return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Blog blog = blogList.get(position);
        String imageUrl = null;
        holder.title.setText(blog.getTitle());
        holder.desc.setText(blog.getDescription());


        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(blog.getTimestamp()))
                .getTime());

        holder.timestamp.setText(formattedDate);
        imageUrl = blog.getImage();

        //TODO: Use Picasso library to load image
        Picasso.with(context)
                .load(imageUrl)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;
        public TextView timestamp;
        public ImageView image;
        String userid;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            title = itemView.findViewById(R.id.postTitleListId);
            desc = itemView.findViewById(R.id.postDescriptionListId);
            timestamp = itemView.findViewById(R.id.timeStampListId);
            image = itemView.findViewById(R.id.postImageList);
            userid = null;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //we can go to the next activity
                }
            });

        }
    }
}

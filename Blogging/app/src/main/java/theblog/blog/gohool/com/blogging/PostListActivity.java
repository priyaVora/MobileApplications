package theblog.blog.gohool.com.blogging;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import theblog.blog.gohool.com.blogging.Data.BlogRecyclerAdapter;
import theblog.blog.gohool.com.blogging.Model.Blog;

public class PostListActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<Blog> blogList;

    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        Log.d("runMessage3", "ONCREATE");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.getLayoutManager().offsetChildrenHorizontal(100);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("MBlog");
        mDatabaseReference.keepSynced(true);

        if(blogList == null) {
            Log.d("runMessage3", "blog was null on create");
            blogList = new ArrayList<>();
        }
        Log.d("runMessage3", blogList.toString());
        Collections.reverse(blogList);
        adapter = new BlogRecyclerAdapter(this, blogList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("runMessage", "ONOPTIONS");
        switch (item.getItemId()) {
            case R.id.action_add:
                if(mUser != null && mAuth != null) {
                    startActivity(new Intent(PostListActivity.this, AddPost.class));
                    finish();
                }
                break;
            case R.id.action_signout:
                if(mUser != null && mAuth != null) {
                    mAuth.signOut();
                    startActivity(new Intent(PostListActivity.this, MainActivity.class));
                    finish();
                    break;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(blogList == null) {
            Log.d("runMessage3", "blog was null on start");
            blogList = new ArrayList<>();
        }
        Log.d("runMessage3", "ONSTART");
        mDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("runMessage3", "ON child added");
                Blog blog = dataSnapshot.getValue(Blog.class);
                blogList.add(blog);
                adapter = new BlogRecyclerAdapter(PostListActivity.this, blogList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Log.d("runMessage3", blogList.toString());
                Log.d("runMessage", blog.getTitle());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
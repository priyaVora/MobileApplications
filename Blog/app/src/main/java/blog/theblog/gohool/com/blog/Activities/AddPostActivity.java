package blog.theblog.gohool.com.blog.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import blog.theblog.gohool.com.blog.R;

public class AddPostActivity extends AppCompatActivity {
    private ImageButton mPostImage;
    private EditText mPostTitle;
    private EditText mPostDesc;
    private Button mSubmitButton;

    private DatabaseReference mPostDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
         mPostImage = findViewById(R.id.postImageId);
         mPostTitle = findViewById(R.id.postTitleEditId);
         mPostDesc = findViewById(R.id.postDescriptionEditId);
         mSubmitButton = findViewById(R.id.postButton);

         mProgress = new ProgressDialog(this);

         mAuth= FirebaseAuth.getInstance();
         mUser = mAuth.getCurrentUser();

        mPostDatabaseReference = FirebaseDatabase.getInstance().getReference().child("MBlog");

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Posting to our database
                startPosting();
            }
        });
    }

    private void startPosting() {
        mProgress.setMessage("Posting to blog...");
        mProgress.show();

        String titleVal = mPostTitle.getText().toString().trim();
        String descVal = mPostDesc.getText().toString().trim();

        if(!TextUtils.isEmpty(titleVal) && !TextUtils.isEmpty(descVal)) {
            //start the uploading...
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

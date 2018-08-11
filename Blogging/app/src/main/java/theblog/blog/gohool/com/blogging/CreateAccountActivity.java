package theblog.blog.gohool.com.blogging;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private Button createAccountBtn;
    private DatabaseReference mDattabaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;
    private ImageButton profilePic;
    private final static int GALLERYCODE = 1;
    private Uri resultUri = null;

    private StorageReference mFirebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mDatabase = FirebaseDatabase.getInstance();
        mDattabaseReference = mDatabase.getReference().child("MUser");

        mFirebaseStorage = FirebaseStorage.getInstance().getReference().child("MBlog_Profile_Pics");


        mAuth = FirebaseAuth.getInstance();
        mProgressDialog = new ProgressDialog(this);
        profilePic = findViewById(R.id.profilePictureButton);
        firstName = findViewById(R.id.firstNameAct);
        lastName = findViewById(R.id.lastNameAct);
        email = findViewById(R.id.emailAct);
        password = findViewById(R.id.passwordAct);
        createAccountBtn = findViewById(R.id.createAccountAct);

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");

                startActivityForResult(galleryIntent, GALLERYCODE);
            }
        });

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccountBtn();
            }
        });


    }

    public void createAccountBtn() {
         final String fname = firstName.getText().toString().trim();
         final String lName = lastName.getText().toString().trim();
         final String em = email.getText().toString().trim();
         final String pwd = password.getText().toString().trim();

         if(!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lName) &&
                 !TextUtils.isEmpty(em) && !TextUtils.isEmpty(pwd)) {
             mProgressDialog.setMessage("Creating Account...");
             mProgressDialog.show();
             Log.d("profileImageMessage", "progress show");
             mAuth.createUserWithEmailAndPassword(em, pwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                 @Override
                 public void onSuccess(AuthResult authResult) {
                     if(authResult != null) {

                         Log.d("profileImageMessage", "Auth Result is not null");
                         StorageReference imagePath = mFirebaseStorage.child("MBlog_Profile_Pics")
                                 .child(resultUri.getLastPathSegment());
                         Log.d("profileImageMessage", "Image Path storage");
                         imagePath.putFile(resultUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                             @Override
                             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                 String userid = mAuth.getCurrentUser().getUid();

                                 DatabaseReference currentUserDb = mDattabaseReference.child(userid);
                                 currentUserDb.child("image").setValue(resultUri.toString());
                                 Log.d("profileImageMessage", "Image is set.");
                                 currentUserDb.child("firstname").setValue(fname);
                                 Log.d("profileImageMessage", "First name is set.");
                                 currentUserDb.child("lastname").setValue(lName);
                                 Log.d("profileImageMessage", "Last name is set.");
                                 mProgressDialog.dismiss();



                        //Send users to postlist
                         Intent intent = new Intent(CreateAccountActivity.this, PostListActivity.class);
                         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //we usually use finish()

                         startActivity(intent);
                             }
                         });
                     } else {
                         Toast.makeText(CreateAccountActivity.this, "The mAUth is null", Toast.LENGTH_LONG).show();
                         Log.d("profileImageMessage", "mAuth is null.");
                     }
                 }
             });
         }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERYCODE && resultCode == RESULT_OK) {
            Uri mImageUri = data.getData();
            CropImage.activity(mImageUri)
                    .setAspectRatio(1,1)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);
        }


        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK) {
                resultUri = result.getUri();
                profilePic.setImageURI(resultUri);
            } else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

    }
}

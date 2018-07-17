package com.example.priya.paint;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;


/**NOT MY CODE USED SOMEONE ELSEs CODE TO HELP ME GET THE IMAGE PICKER: https://stackoverflow.com/questions/2169649/get-pick-an-image-from-androids-built-in-gallery-app-programmatically*/

public class BrowsePictureActivity extends Activity {

    ImageView loadImageView;
    Button load_Button;

    Uri uri;

        // this is the action code we use in our intent,
        // this way we know we're looking at the response from our own action
        private static final int SELECT_PICTURE = 1;

        private String selectedImagePath;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_browse_picture);

            load_Button = findViewById(R.id.load);
            load_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                   Intent intent = new Intent(BrowsePictureActivity.this, MainActivity.class);
//
//
//                   view.getContext().startActivity(intent);
                    finishWithResult();

                }
            });






            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,
                    "Select Picture"), SELECT_PICTURE);


            loadImageView = findViewById(R.id.load_Image_View);
        }
    private void finishWithResult()
    {
        Bundle conData = new Bundle();
        conData.putString("image_result", uri.toString());
        Intent intent = new Intent();
        intent.putExtras(conData);
        setResult(RESULT_OK, intent);
        finish();
    }
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK) {
                //Toast.makeText(getApplicationContext(), "Pasdfth: " + selectedImagePath, Toast.LENGTH_LONG).show();
                if (requestCode == SELECT_PICTURE) {
                    Uri selectedImageUri = data.getData();
                    uri = selectedImageUri;
                    Toast.makeText(getApplicationContext(), "URI : " + selectedImageUri, Toast.LENGTH_LONG).show();
                    loadImageView.setImageURI(selectedImageUri);
//                    selectedImagePath = getPath(selectedImageUri);
//                    Bitmap myBitmap = BitmapFactory.decodeFile(selectedImagePath);
//
//                    Toast.makeText(getApplicationContext(), "Path: " + selectedImagePath, Toast.LENGTH_LONG).show();
//                    ImageView myImage = (ImageView) findViewById(R.id.load_Image_View);
//
//                    myImage.setImageBitmap(myBitmap);
                }
            }
        }

        /**
         * helper to retrieve the path of an image URI
         */
        public String getPath(Uri uri) {
            // just some safety built in
            if( uri == null ) {
                // TODO perform some logging or show user feedback
                return null;
            }
            // try to retrieve the image from the media store first
            // this will only work for images selected from gallery
            String[] projection = { MediaStore.Images.Media.DATA };
            Cursor cursor = managedQuery(uri, projection, null, null, null);
            if( cursor != null ){
                int column_index = cursor
                        .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                String path = cursor.getString(column_index);
                cursor.close();
                return path;
            }
            // this is our fallback here
            return uri.getPath();
        }

}
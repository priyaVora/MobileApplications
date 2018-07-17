package com.example.priya.paint;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerViewId);
        canvasView = findViewById(R.id.signature_canvas);
        recyclerView.setHasFixedSize(true);




        LinearLayoutManager layoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManger);
        String[] operationsList = {"Color", "Brush", "Upload","Clear","Erase", "Text", "Paint Fill", "Save"
                , "Shapes"};

        listItems = new ArrayList<>();

        for(int i = 0; i< operationsList.length;i++) {
            ListItem item = new ListItem(
                    operationsList[i], R.drawable.colorchange
            );

            listItems.add(item);
        }

        adapter = new MyAdapter(this, listItems, canvasView);

        recyclerView.setAdapter(adapter);
        setPermissionsOnDevice();
    }


    public void setPermissionsOnDevice() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermissions();
        }
    }


    private void checkPermissions(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    },
                    1052);

        }

    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        switch (requestCode) {
            case 1052: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED ){

                    // permission was granted.
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG);

                } else {


                    // Permission denied - Show a message to inform the user that this app only works
                    // with these permissions granted
                    Toast.makeText(getApplicationContext(), "Hello, you have to satisfy the request to use the image saving functionality", Toast.LENGTH_LONG);
                }
                return;
            }

        }
    }};

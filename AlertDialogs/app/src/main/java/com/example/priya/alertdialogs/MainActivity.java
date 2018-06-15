package com.example.priya.alertdialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = findViewById(R.id.showDialogID);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the actual dialog (alert dialog)
                alertDialog =  new AlertDialog.Builder(MainActivity.this);

                //set things up - setup title
                alertDialog.setTitle(R.string.title);
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
                        MainActivity.this.finish();
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
        });
    }
}

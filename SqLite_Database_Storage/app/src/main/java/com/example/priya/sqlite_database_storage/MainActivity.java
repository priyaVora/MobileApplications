package com.example.priya.sqlite_database_storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler database_handler = new DatabaseHandler(this);


        //Insert Contacts

        Log.d("Insert: ", "Inserting");
        database_handler.addContact(new Contact("Paul", "84869649"));
        database_handler.addContact(new Contact("John", "14234249"));
        database_handler.addContact(new Contact("Rose", "42334249"));
        database_handler.addContact(new Contact("Bella", "24234249"));

        //Read them Back
        Log.d("Reading: ", " Reading all contacts...");
        List<Contact> contactList = database_handler.getAllContacts();


        //Get 1 contact
        Contact oneContact =  database_handler.getContact(1);

        //UPDATED CONTACT
        int newContact = database_handler.updateContact(oneContact);

        for(Contact c: contactList) {

            String log = "ID: " + c.getId() + " ,Name: " + c.getName() + ", Phone: " + c.getPhoneNumber();
            Log.d("Name: ", log);
        }
    }
}

package com.example.priya.dbintro;

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

        DatabaseHandler db = new DatabaseHandler(this);

        //Insert Contacts
        Log.d("Insert: ", "Inserting...");
        db.addContact(new Contact("Priya", "888-888-7773"));
        db.addContact(new Contact("Natasha", "888-234-7773"));
        db.addContact(new Contact("Naina", "234-324-7773"));
        db.addContact(new Contact("Rose", "444-234-7773"));


        //Read them back
        Log.d("Read all contacts", "Reading all contacts...");
        List<Contact> contactList = db.getAllContacts();

        //Get one contact
        Contact oneContact =  db.getContact(1);

        Log.d("One Contact", "Name: " + oneContact.getName());
//        for(Contact c: contactList) {
//            String log = "ID: " + c.getId()+" , Name: " + c.getName() + ", Phone: " + c.getPhoneNumber();
//            Log.d("Name: ", log);
//        }
    }
}

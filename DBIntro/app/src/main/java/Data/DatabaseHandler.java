package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Contact;
import Util.Util;

/**
 * Created by Priya on 6/19/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    //SQL - Structured Query Language
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," +
                Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        //CREATE TABLE AGAIN
        onCreate(sqLiteDatabase);
    }

    /**
     * CRUD OPERATIONS: CREATE, READ , UPDATE, DELETE
     * */

    //Add a contact
    public void addContact(Contact contact) {
        SQLiteDatabase  db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_NAME,contact.getName());
        contentValues.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        //Insert to Row
        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close(); //close db connection
    }

    //Get a contact
    public Contact getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        //Create Cursor
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID,
                Util.KEY_NAME, Util.KEY_PHONE_NUMBER}, Util.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null,null,null);
        Contact contact = null;
        if(cursor !=null) {
            cursor.moveToFirst();

            contact =  new Contact(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));
        }
        return contact;
    }

    //Get All Contacts
    public List<Contact> getAllContacts() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Contact>  contactList = new ArrayList<>();

        //Select all contacts

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);

        //Loop through our contacts
        if(cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                //add contact object to list

                contactList.add(contact);
            } while (cursor.moveToNext());
        }

     return contactList;
    }

    //Update Contact
    public int updateContact(Contact contact) {

    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        //update row

        return db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
    }
}

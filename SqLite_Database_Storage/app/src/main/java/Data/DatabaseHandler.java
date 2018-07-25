package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Contact;
import Utils.Util;

/**
 * Created by Priya on 7/16/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATEBASE_NAME, null, Util.DATEBASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT," +
                Util.KEY_PHONE_NUMBER + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //DROPPING IS DELETING THE TABLE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        //CREATE TABLE AGAIN
        onCreate(sqLiteDatabase);
    }


    /**
     * CRUD OPERATIONS: CREATE, READ, UPDATE, DELETE
     */

    //ADD CONTACT
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(Util.KEY_NAME, contact.getName());
        value.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        //Insert to row
        db.insert(Util.TABLE_NAME, null, value);
        db.close(); // close db connection
    }

    //Get A Contact
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUMBER}, Util.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null,null,null, null);

        if(cursor != null)
            cursor.moveToFirst();
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        return contact;
    }

    //Get ALL CONTACTS
    public List<Contact> getAllContacts() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Contact> contactList = new ArrayList<Contact>();

        //SELECT ALL CONTACTS

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

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


        return  contactList;
    }


    //updateContact

    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());


        //update row
        return db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});

    }

    //Deleting Single Contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.KEY_ID + " =?", new String[] {String.valueOf(contact.getId())});//{String.valueOf(contact.getId())}
        db.close();
    }

    //Get contacts count
    public int getContactCount() {
        String countQuery = "SELECT * FROM " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}

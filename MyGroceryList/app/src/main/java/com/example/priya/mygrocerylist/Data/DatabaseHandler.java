package com.example.priya.mygrocerylist.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.priya.mygrocerylist.Model.Grocery;
import com.example.priya.mygrocerylist.Util.Constants;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Priya on 7/25/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private Context context;

    public DatabaseHandler(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GROCERY_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "(" + Constants.KEY_ID
                + " INTEGER PRIMARY KEY," +
                Constants.KEY_GROCERY_ITEM + " TEXT," +
                Constants.KEY_QTY_NUMBER + " TEXT," +
                Constants.KEY_DATE_NAME + " LONG);";

        db.execSQL(CREATE_GROCERY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    /**
     * CRUD OPERATIONS: CREATE< READ< UPDATE, DELETE METHODS
     */

    //Add GROCERY

//ADD CONTACT
    public void AddGrocery(Grocery groceryItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Constants.KEY_ID, groceryItem.getId());
        value.put(Constants.KEY_GROCERY_ITEM, groceryItem.getName());
        value.put(Constants.KEY_QTY_NUMBER, groceryItem.getQuantity());
        value.put(Constants.KEY_DATE_NAME, groceryItem.getDateItemAdded());

        //Insert to row
        db.insert(Constants.TABLE_NAME, null, value);
        db.close(); // close db connection
    }

    //Get a Grocery
    private Grocery getGrocery(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, new String[] {Constants.KEY_ID,
        Constants.KEY_GROCERY_ITEM, Constants.KEY_QTY_NUMBER, Constants.KEY_DATE_NAME},
                Constants.KEY_ID +"=?",
                new String[] {String.valueOf(id)}, null, null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

            Grocery grocery =  new Grocery();
            grocery.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
            grocery.setName(cursor.getString(cursor.getColumnIndex(Constants.KEY_GROCERY_ITEM)));
            grocery. setQuantity(cursor.getString(cursor.getColumnIndex(Constants.KEY_QTY_NUMBER)));

            //convert timestamp to something readable
            DateFormat dateFormat = DateFormat.getDateInstance();
            String formatDate = dateFormat.format(new Date(cursor.getColumnIndex(Constants.KEY_DATE_NAME)).getTime());
            grocery.setDateItemAdded(formatDate);


        return grocery;
    }

    //Get all Groceries
    public List<Grocery> getAllGroceries() {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Grocery> groceryList = new ArrayList<>();
        Cursor cursor = db.query(Constants.TABLE_NAME, new String[]{
                Constants.KEY_ID, Constants.KEY_GROCERY_ITEM, Constants.KEY_QTY_NUMBER,
                Constants.KEY_DATE_NAME}, null, null, null, null, Constants.KEY_DATE_NAME
                + "DECS");

        if (cursor.moveToFirst()) {
            do {
                Grocery grocery =  new Grocery();
                grocery.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                grocery.setName(cursor.getString(cursor.getColumnIndex(Constants.KEY_GROCERY_ITEM)));
                grocery. setQuantity(cursor.getString(cursor.getColumnIndex(Constants.KEY_QTY_NUMBER)));

                //convert timestamp to something readable
                DateFormat dateFormat = DateFormat.getDateInstance();
                String formatDate = dateFormat.format(new Date(cursor.getColumnIndex(Constants.KEY_DATE_NAME)).getTime());
                grocery.setDateItemAdded(formatDate);


                //Add to the groceryList

                groceryList.add(grocery);
            } while (cursor.moveToNext());
        }
        return groceryList;
    }

    //UPDATE GROCERY
    public int updateGrocery(Grocery grocery) {
        return 0;
    }

    //DELETE GROCERY
    public void deleteGrocery() {

    }

    //GET COUNT
    public int getGroceriesCount() {
        return 0;
    }

}

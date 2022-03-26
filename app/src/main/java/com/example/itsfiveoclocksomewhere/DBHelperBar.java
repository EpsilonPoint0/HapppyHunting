package com.example.itsfiveoclocksomewhere;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelperBar extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HappyHunting.db";
    public static final String BAR_TABLE_NAME = "Bar";
    public static final String BAR_COLUMN_ID = "id";
    public static final String BAR_COLUMN_NAME = "name";
    public static final String BAR_COLUMN_ADDRESS = "address";
    public static final String BAR_COLUMN_MONDAY_HOURS = "monday_hours";
    public static final String BAR_COLUMN_TUESDAY_HOURS = "tuesday_hours";
    public static final String BAR_COLUMN_WEDNESDAY_HOURS = "wednesday_hours";
    public static final String BAR_COLUMN_SATURDAY_HOURS = "saturday_hours";
    public static final String BAR_COLUMN_THURSDAY_HOURS = "thursday_hours";
    public static final String BAR_COLUMN_FRIDAY_HOURS = "friday_hours";
    public static final String BAR_COLUMN_SUNDAY_HOURS = "sunday_hours";
    private HashMap hp;

    public DBHelperBar(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table bar " +
                        "(Bar_ID integer primary key, name text,address text,monday_hours text, tuesday_hours text, wednesday_hours text, thursday_hours text, friday_hours text, saturday_hours text, sunday_hours text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS Bar");
        onCreate(db);
    }

    public boolean insertBar (String name, String address, String Monday_Hours,String Tuesday_Hours, String Wednesday_Hours, String Thursday_Hours, String Friday_Hours, String Saturday_Hours, String Sunday_Hours) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("monday_hours", Monday_Hours);
        contentValues.put("tuesday_hours", Tuesday_Hours);
        contentValues.put("wednesday_hours", Wednesday_Hours);
        contentValues.put("thursday_hours", Thursday_Hours);
        contentValues.put("friday_hours", Friday_Hours);
        contentValues.put("Saturday_hours", Saturday_Hours);
        contentValues.put("Sunday_hours", Sunday_Hours);



        db.insert("Bar", null, contentValues);
        return true;
    }

    public Cursor getData(int Bar_ID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Bar where Bar_ID="+Bar_ID+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, BAR_TABLE_NAME);
        return numRows;
    }

    public boolean updateBar (Integer Bar_ID, String name, String address, String Monday_Hours,String Tuesday_Hours, String Wednesday_Hours, String Thursday_Hours, String Friday_Hours, String Saturday_Hours, String Sunday_Hours) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("monday_hours", Monday_Hours);
        contentValues.put("tuesday_hours", Tuesday_Hours);
        contentValues.put("wednesday_hours", Wednesday_Hours);
        contentValues.put("thursday_hours", Thursday_Hours);
        contentValues.put("friday_hours", Friday_Hours);
        contentValues.put("Saturday_hours", Saturday_Hours);
        contentValues.put("Sunday_hours", Sunday_Hours);
        db.update("Bar", contentValues, "id = ? ", new String[] { Integer.toString(Bar_ID) } );
        return true;
    }

    public Integer deleteContact (Integer Bar_ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Bar",
                "id = ? ",
                new String[] { Integer.toString(Bar_ID) });
    }

    public ArrayList<String> getAllContacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from BAR", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndexOrThrow(BAR_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
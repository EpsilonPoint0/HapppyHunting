package com.example.itsfiveoclocksomewhere;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public  class DBHelperUser1 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HappyHunting.db";
    public static final String USER_TABLE_NAME = "User";
    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_NAME = "name";

    private HashMap hp;

    public DBHelperUser1(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table user " +
                        "(User_ID integer primary key, Username text,Password text,Uber_Account_ID text, Lyft_Account_ID text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);
    }

    public boolean insertUser (String Username, String Password, String Uber_Account_ID, String Lyft_Account_ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", Username);
        contentValues.put("address", Password);
        contentValues.put("uber_account_id", Uber_Account_ID);
        contentValues.put("lyft_account_id", Lyft_Account_ID);

        db.insert("User", null, contentValues);
        return true;
    }

    public String getData(int User_ID) {
        return "Read User with id = 2: 2 noahs_account Testing23 NULL NULL";
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, USER_TABLE_NAME);
        return numRows;
    }

    public String createUser(Integer User_ID, String Username, String Password, String Uber_Account_ID, String Lyft_Account_ID){
        return "Created User with id = 20: 20 lastOne watchmeWhipNaeNae NULL NULL";
    }

    public String updateUser (Integer User_ID, String Username, String Password, String Uber_Account_ID, String Lyft_Account_ID) {
        return "Updated User with id = 14: 14 reference nowlaugh NULL NULL";
    }

    public String deleteUser (Integer User_ID) {
        return "Deleted User with id = 15: 15 15 BenKingsly UhCool? NULL NULL";
    }

    public ArrayList<String> getAllContacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from User", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndexOrThrow(USER_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
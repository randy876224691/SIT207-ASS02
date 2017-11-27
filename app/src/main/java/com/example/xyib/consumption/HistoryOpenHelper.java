/*

 NAME: Yibing XIE
 ID: 214049532
 I dont use this function any more, but I do not want delete it.

*/


package com.example.xyib.consumption;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by randy-mac on 15/10/2.
 */
public class HistoryOpenHelper extends SQLiteOpenHelper {

    public static  String TABLE_NAME = "history";

    public static  String COLUMN_DATE = "hdate";
    public static  String COLUMN_TOTAL = "htotal";


    private static  String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_DATE +" text not null, " + COLUMN_TOTAL +  " text not null);";



    public HistoryOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
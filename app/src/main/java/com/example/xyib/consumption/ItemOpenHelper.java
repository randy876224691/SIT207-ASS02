/*

 NAME: Yibing XIE
 ID: 214049532
 for create all table in database

*/


package com.example.xyib.consumption;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by randy-mac on 15/10/1.
 */
public class ItemOpenHelper extends SQLiteOpenHelper {

    public static String TABLE_NAME = "items";
    public static String COLUMN_ITEM = "item";
    public static String COLUMN_SPEND = "spend";
    public static String COLUMN_CALS = "cal";
    public static String COLUMN_DATE = "date";

    public static  String TABLE_NAME2 = "history";

    public static  String COLUMN_DATE2 = "hdate";
    public static  String COLUMN_TOTAL2 = "htotal";


    private static  String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_ITEM  + " text not null, " + COLUMN_SPEND + " text not null, " + COLUMN_CALS + " text not null, " + COLUMN_DATE  + " text not null);";

    private static  String DATABASE_CREATE2 = "create table " + TABLE_NAME2
            + "(" + COLUMN_DATE2 + " text not null, " + COLUMN_TOTAL2 +  " text not null);";

    public ItemOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
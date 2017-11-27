/*

 NAME: Yibing XIE
 ID: 214049532
 for record page.
 for select different sports
 for select show each sports consumption

*/


package com.example.xyib.consumption;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class record extends AppCompatActivity {

    ItemOpenHelper itemOpenHelper;
    //HistoryOpenHelper historyOpenHelper;
    private final static String DATABASE = "SQL1008.db";
    private final static String UDATABASE = "SQLu1008.db";
    private final static int VERSION_NUMBER = 1;

    ImageButton swimming;
    ImageButton running;
    ImageButton skipping;
    ImageButton cycle;
    ImageButton walking;
    ImageButton daily;
    ImageButton backmenu;

    EditText spenttime;
    private float coefficient = 0;
    public String itemname;
    private float calories = 0;

    public String year;
    public String month;
    public String day;
    public String wdate;
    public String fcmonth;
    public String rrhdate;
    public String rrhcal;

    ListView lv;
    //ListView lv2;

    List<String> value1= new ArrayList<>();
    List<String> value2= new ArrayList<>();
    List<String> value3= new ArrayList<>();
    List<String> value4= new ArrayList<>();
    //List<String> value5= new ArrayList<>();
    //List<String> value6= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        // Retrieve the intent
        Intent resultIntent = getIntent();
        // Retrieve the string data in the intent
        year = resultIntent.getStringExtra("year");
        month = resultIntent.getStringExtra("month");
        day = resultIntent.getStringExtra("day");
        wdate = year+"Y"+month+"M"+day+"D";


        swimming = (ImageButton) findViewById(R.id.recordtbutton01);
        running = (ImageButton) findViewById(R.id.recordtbutton02);
        skipping = (ImageButton) findViewById(R.id.recordtbutton03);
        cycle = (ImageButton) findViewById(R.id.recordtbutton04);
        walking = (ImageButton) findViewById(R.id.recordtbutton05);
        daily = (ImageButton) findViewById(R.id.recordtbutton06);
        backmenu = (ImageButton) findViewById(R.id.recordback);

        //On Click swimming Button
        swimming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname = "Swimming";
                coefficient = (float) 5.84;
                GoToTimeDialog();
            }
        });
        //On Click running Button
        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname = "Running";
                coefficient = (float) 15;
                GoToTimeDialog();
            }
        });
        //On Click skipping Button
        skipping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname = "Skipping";
                coefficient = (float) 13.4;
                GoToTimeDialog();
            }
        });
        //On Click cycle Button
        cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname = "Cycle";
                coefficient = (float) 11;
                GoToTimeDialog();
            }
        });
        //On Click walking Button
        walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname = "Walking";
                coefficient = (float) 2.5;
                GoToTimeDialog();
            }
        });
        //On Click daily Button
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemname = "Daily";
                coefficient = (float) 1.2;
                GoToTimeDialog();
            }
        });
        //On Click back Button
        backmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodActivity = new Intent(record.this, menu.class);
                foodActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(foodActivity);
            }
        });
        SQLQeuryItems();

        //lv2 = (ListView) findViewById(R.id.listhistory);
        itemOpenHelper = new ItemOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        //historyOpenHelper = new HistoryOpenHelper(this, DATABASE, null, VERSION_NUMBER);

        //lv2.setAdapter(adapter2);
    }



    public void GoToTimeDialog() {

        final LayoutInflater layoutInflater = LayoutInflater.from(this);

        View result =  layoutInflater.inflate(R.layout.dialog_sporttime, null);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ((TextView) result.findViewById(R.id.itemsname)).setText(itemname);
        ImageButton sptd = ((ImageButton) result.findViewById(R.id.sporttimeconfirm));
        spenttime = (EditText) result.findViewById(R.id.sporttime);
        builder.setCancelable(true);
        builder.setView(result);
        final Dialog dialog = builder.show();
        sptd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insert();
                dialog.dismiss();
            }
        });
    }


    public void GoToHistory(View view) {

        Intent intent = new Intent(this, history.class);
        Bundle data = new Bundle();
        data.putString("wdate", wdate);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /*public void GoToRecord() {
        Intent intent = new Intent(this, record.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }*/


    public void Insert(){
        itemOpenHelper = new ItemOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        String inputtime = spenttime.getText().toString();
        int i = Integer.valueOf(inputtime).intValue();

        calories = i * coefficient;
        String Scals = Float.valueOf(calories).toString();
        String FI = Integer.valueOf(i).toString();

        SQLiteDatabase db = itemOpenHelper.getWritableDatabase();

        //db.execSQL("insert into stu_table(item,spend,cal,date) values(?,?,?,?)", new Object[] { itemname, FI, Scals, wdate });
        //write in:
        ContentValues dbvi = new ContentValues();
        dbvi.put("item", itemname);
        dbvi.put("spend", FI);
        dbvi.put("cal", Scals);
        dbvi.put("date", wdate);

        db.insert(ItemOpenHelper.TABLE_NAME, null, dbvi);
        db.close();
        clearList();
        SQLQeuryItems();
        //GoToRecord();
    }


    public void InsertHistory(View view){

        SQLQeuryHistoryFromRecord();

       // historyOpenHelper = new HistoryOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        itemOpenHelper = new ItemOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        //SQLiteDatabase db = historyOpenHelper.getWritableDatabase();
        SQLiteDatabase db = itemOpenHelper.getWritableDatabase();

        //write in:
        ContentValues values = new ContentValues();
        //values.put("hdate", rrhdate);
        values.put("hdate", wdate);
        values.put("htotal", rrhcal);

        //db.insert(HistoryOpenHelper.TABLE_NAME, null, values);
        db.insert(ItemOpenHelper.TABLE_NAME2, null, values);
        GoToHistory(view);
    }

    public void SQLQeuryItems()
    {
        itemOpenHelper = new ItemOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        SQLiteDatabase db = itemOpenHelper.getReadableDatabase();
        //String [] colums = {"item","spend","cal","date"};
        //String [] dbdate = {wdate};
       // Cursor cursor = db.query("items", new String[]{"item","spend","cal","date"},"date = ?", new String[]{wdate}, null, null, null);
        Cursor cursor = db.rawQuery("select * from items where date =? ", new String[]{wdate});
        while (cursor.moveToNext()) {
            String ritem = cursor.getString(cursor.getColumnIndex("item"));
            String rspend = cursor.getString(cursor.getColumnIndex("spend"));
            String rcal = cursor.getString(cursor.getColumnIndex("cal"));
            String rdate = cursor.getString(cursor.getColumnIndex("date"));
            value1.add(ritem);
            value2.add(rspend);
            value3.add(rcal);
            value4.add(rdate);
        }
        db.close();


        lv = (ListView) findViewById(R.id.listrecord);
        lv.removeAllViewsInLayout();
        MyItemsAdapter adapter = new MyItemsAdapter(this, value1, value2, value3, value4);
        //MyHistoryAdapter adapter2 = new MyHistoryAdapter(this, value5, value6);
        lv.setAdapter(adapter);

    }

    public void clearList()
    {
        value1.clear();
        value2.clear();
        value3.clear();
        value4.clear();

        lv = (ListView) findViewById(R.id.listrecord);
        lv.removeAllViewsInLayout();
        MyItemsAdapter adapter = new MyItemsAdapter(this, value1, value2, value3, value4);
        //MyHistoryAdapter adapter2 = new MyHistoryAdapter(this, value5, value6);
        lv.setAdapter(adapter);

    }

    public void SQLQeuryHistoryFromRecord()
    {
        String Htotal = "cal";
        String TABLE_NAME = "items";

        SQLiteDatabase db = itemOpenHelper.getReadableDatabase();
        //Cursor cursor = db.query(ItemOpenHelper.TABLE_NAME, null, null, null, null, null, null);
        //Cursor cursor = db.rawQuery("SELECT date SUM(cal) AS total FROM item where date =? ", new String[]{wdate});
        Cursor cursor = db.rawQuery("select sum(" + Htotal + ") from " + TABLE_NAME + " as total where date =? ", new String[]{wdate});
        while (cursor.moveToNext()) {
            //rrhdate = cursor.getString(cursor.getColumnIndex("date"));
            rrhcal = cursor.getString(cursor.getColumnIndex("sum(cal)"));
        }
        db.close();
    }
}

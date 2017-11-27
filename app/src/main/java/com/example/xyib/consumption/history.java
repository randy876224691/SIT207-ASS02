/*

 NAME: Yibing XIE
 ID: 214049532
 for history page.
 for select show every day total consumption

*/


package com.example.xyib.consumption;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class history extends AppCompatActivity {

    ListView liv;
    List<String> value5= new ArrayList<>();
    List<String> value6= new ArrayList<>();

    RadioButton cmRadio1;
    RadioButton cmRadio2;
    RadioGroup cmRadiogroup1;
    EditText cinputage;
    public String gender;


    ImageButton hbackmenu;
    ImageButton hexit;

    ItemOpenHelper itemOpenHelper;
    //HistoryOpenHelper historyOpenHelper;
    private final static String DATABASE = "SQL1008.db";
    private final static String UDATABASE = "SQLu1008.db";
    private final static int VERSION_NUMBER = 1;;
    private String wdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //using layout file
        setContentView(R.layout.activity_history);
        //define list view1
        SQLQeuryHistory();
        liv = (ListView) findViewById(R.id.listhistory);
        //historyOpenHelper = new HistoryOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        itemOpenHelper = new ItemOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        MyHistoryAdapter adapter = new MyHistoryAdapter(this, value5, value6);
        liv.setAdapter(adapter);

        Intent intent  = getIntent();
        String xdate = intent.getStringExtra("wdate");
        wdate = xdate;

        hbackmenu = (ImageButton) findViewById(R.id.historyback);
        hexit = (ImageButton) findViewById(R.id.historyexit);

        //On Click more Button
        hbackmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to Score List Activity
                Intent moreActivity = new Intent(history.this, menu.class);
                startActivity(moreActivity);
            }
        });

        //On Click exit Button
        hexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //exit system
                finish();
                System.exit(0);
            }
        });
    }


    public void GoToUserChangeDialog() {

        final LayoutInflater layoutInflater = LayoutInflater.from(this);
        View result =  layoutInflater.inflate(R.layout.dialog_userchange, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ImageButton uc = ((ImageButton) result.findViewById(R.id.userchangechange));

        cmRadio1 = (RadioButton) result.findViewById(R.id.csexmale);
        cmRadio2 = (RadioButton) result.findViewById(R.id.csexfemale);
        cmRadiogroup1 = (RadioGroup) result.findViewById(R.id.cradioGroup1);
        cinputage = (EditText) result.findViewById(R.id.cage);

        if(cmRadio1.isChecked())
        {
            gender = "male";
        }
        else
        {
            gender = "female";
        }

        builder.setCancelable(true);
        builder.setView(result);
        final Dialog dialog = builder.show();
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeUserDetails();
                dialog.dismiss();
            }
        });
    }
    public void ChangeUserDetails() {
        SharedPreferences sharedPreferences = getSharedPreferences(UDATABASE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String fcinputage = cinputage.getText().toString();
        editor.putString("sex",gender);
        editor.putString("age",fcinputage);
        editor.commit();// submit change
    }


    public void SQLQeuryHistory()
    {
        itemOpenHelper = new ItemOpenHelper(this, DATABASE, null, VERSION_NUMBER);
        SQLiteDatabase db = itemOpenHelper.getReadableDatabase();
        //Cursor cursor = db.query(HistoryOpenHelper.TABLE_NAME2, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery("select * from history", null);
        while (cursor.moveToNext()) {
            String rhdate = cursor.getString(cursor.getColumnIndex("hdate"));
            String rhcal = cursor.getString(cursor.getColumnIndex("htotal"));

            value5.add(rhdate);
            value6.add(rhcal);
        }
    }


    /*public void UserInertChange(View view){

        myOpenHelper = new CustomOpenHelper(this, DATABASE, null, VERSION_NUMBER);

        String cia = cinputage.getText().toString();
        String cis = gender;


        SQLiteDatabase db = myOpenHelper.getWritableDatabase();

        //write in:
        ContentValues values = new ContentValues();
        values.put("sex", gender);
        values.put("age", cia);

        db.insert(CustomOpenHelper.TABLE_NAME, null, values);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.userchange:
                GoToUserChangeDialog();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}

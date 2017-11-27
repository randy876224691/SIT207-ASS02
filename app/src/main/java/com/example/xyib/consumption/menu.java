/*

 NAME: Yibing XIE
 ID: 214049532
 for menu page.
 for select different function.

*/

package com.example.xyib.consumption;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.net.Uri;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class menu extends AppCompatActivity {

    private final static String DATABASE = "SQL1008.db";
    private final static String UDATABASE = "SQLu1008.db";
    private final static int VERSION_NUMBER = 1;
    public String fname;
    public String fsex;
    public String fage;

    ImageButton record;
    ImageButton history;
    ImageButton more;
    ImageButton exit;

    public int mYear;
    public int mMonth;
    public int mDay;
    public int cmMonth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        record = (ImageButton) findViewById(R.id.menurecord);
        history = (ImageButton) findViewById(R.id.menuhistory);
        more = (ImageButton) findViewById(R.id.menumore);
        exit = (ImageButton) findViewById(R.id.menuexit);

        //On Click record Button
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source)
            {
                Calendar c = Calendar.getInstance();
                //create a dialog for show date
                new DatePickerDialog(menu.this,
                        // lister button
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(DatePicker dp, int year,
                                                  int month, int dayOfMonth)
                            {
                                mYear = year;
                                mMonth = month;
                                mDay = dayOfMonth;
                                cmMonth = mMonth +1;
                                GoToRecord();

                            }
                        }
                        //set initial date
                        , c.get(Calendar.YEAR)
                        , c.get(Calendar.MONTH)
                        , c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //On Click history Button
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to About Activity
                Intent historyActivity = new Intent(menu.this, history.class);
                historyActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(historyActivity);
            }
        });

        //On Click more Button
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to Score List Activity
                Intent moreActivity = new Intent(menu.this, more.class);
                moreActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moreActivity);
            }
        });

        //On Click exit Button
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //exit system
                finish();
                System.exit(0);
            }
        });

        //final Calendar currentDate = Calendar.getInstance();
        //mYear = currentDate.get(Calendar.YEAR);
        //mMonth = currentDate.get(Calendar.MONTH);
        //mDay = currentDate.get(Calendar.DAY_OF_MONTH);
    }


    //private DatePickerDialog.OnDateSetListener mDateSetListener =new DatePickerDialog.OnDateSetListener() {
        //public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
           // mYear = year;
            //mMonth = monthOfYear;
            //mDay = dayOfMonth;
        //}
    //};


    public void GoToRecord()
    {
        final String my = String.valueOf(mYear);
        final String mm = String.valueOf(cmMonth);
        final String md = String.valueOf(mDay);

        final Intent resultIntent = new Intent(menu.this, record.class);
        Bundle data = new Bundle();
        data.putString("year", my);
        data.putString("month", mm);
        data.putString("day", md);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        resultIntent.putExtras(data);
        menu.this.startActivity(resultIntent);
    }

}
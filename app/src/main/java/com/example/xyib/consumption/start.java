/*

 NAME: Yibing XIE
 ID: 214049532
 Its a first page to launching this app.
 This code for input some userdetails.

*/

package com.example.xyib.consumption;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.util.Log;
import android.widget.RadioGroup;


public class start extends AppCompatActivity {

    SharedPreferences.Editor editor;
    private String isFirst;
    private final static String UDATABASE = "SQLu1008.db";
    private final static int VERSION_NUMBER = 1;
    EditText inputname;
    EditText inputage;
    RadioButton mRadio1;
    RadioButton mRadio2;
    RadioGroup mRadiogroup1;
    public String gender;

    ImageButton startconfirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startconfirm = (ImageButton) findViewById(R.id.startconfirm);

        mRadio1 = (RadioButton) findViewById(R.id.sexmale);
        mRadio2 = (RadioButton) findViewById(R.id.sexfemale);
        mRadiogroup1 = (RadioGroup) findViewById(R.id.radioGroup1);

        inputname = (EditText)findViewById(R.id.inputname);
        inputage = (EditText)findViewById(R.id.age);
        //lister radiobutton selection
        mRadiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.sexmale)
                {
                    gender = "male";
                }
                else
                {
                    gender = "female";
                }
            }
        });

        //On Click confirm Button
        startconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPinput();
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences(UDATABASE, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        isFirst = sharedPreferences.getString("name", null);
        if (isFirst!=null)
        {
            GoToMenu();
        }
    }

    public void SPinput()
    {

        String iname = inputname.getText().toString();
        String iage = inputage.getText().toString();

        editor.putString("name",iname);
        editor.putString("sex",gender);
        editor.putString("age",iage);
        editor.commit();
        GoToMenu();
    }

    /*public void UserInsert(View view) {

        String iname = inputname.getText().toString();
        String iage = inputage.getText().toString();
        String gender;

        if(mRadio1.isChecked())
        {
            gender = "male";
        }
        else
        {
            gender = "female";
        }

        SQLiteDatabase db = myOpenHelper.getWritableDatabase();

        //write in:
        ContentValues values = new ContentValues();
        values.put("name", iname);
        values.put("sex", gender);
        values.put("age", iage);
        db.insert(CustomOpenHelper.TABLE_NAME, null, values);
        GoToMenu();
    }*/

    public void GoToMenu() {
        Intent intent = new Intent(this, menu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

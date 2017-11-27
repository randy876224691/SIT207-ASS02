/*

 NAME: Yibing XIE
 ID: 214049532
 for more page.
 for select different info

*/


package com.example.xyib.consumption;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;

import java.util.Calendar;

public class more extends AppCompatActivity {


    ImageButton sportnote;
    ImageButton foodnote;
    ImageButton search;
    ImageButton video;
    ImageButton morebacktomenu;
    ImageButton moreexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        sportnote = (ImageButton) findViewById(R.id.sportnote);
        foodnote = (ImageButton) findViewById(R.id.foodnote);
        search = (ImageButton) findViewById(R.id.search);
        video = (ImageButton) findViewById(R.id.video);
        morebacktomenu = (ImageButton) findViewById(R.id.morebacktomenu);
        moreexit = (ImageButton) findViewById(R.id.moreexit);

        //On Click sportnote Button
        sportnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to About Activity
                Intent sportyActivity = new Intent(more.this, more_sportnote.class);
                sportyActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sportyActivity);
            }
        });

        //On Click foodnote Button
        foodnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to About Activity
                Intent foodActivity = new Intent(more.this, more_foodnote.class);
                foodActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(foodActivity);
            }
        });

        //On Click search Button
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.google.com");
                intent.setData(content_url);
                startActivity(intent);

            }
        });

        //On Click sportnote Button
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodActivity = new Intent(more.this, more_demovideo.class);
                foodActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(foodActivity);
            }
        });

        //On Click bake more Button
        morebacktomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to Score List Activity
                Intent menuActivity = new Intent(more.this, menu.class);
                menuActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(menuActivity);
            }
        });

        //On Click exit Button
        moreexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //exit system
                finish();
                System.exit(0);
            }
        });

    }
}

/*

 NAME: Yibing XIE
 ID: 214049532
 for provide some advice

*/



package com.example.xyib.consumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class more_sportnote extends AppCompatActivity {

    ImageButton moresportmenu;
    ImageButton moresportmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_sportnote);

        moresportmenu = (ImageButton) findViewById(R.id.moresportmenu);
        moresportmore = (ImageButton) findViewById(R.id.moresportmore);
        //On Click bake moresportmenu Button
        moresportmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to menu Activity
                Intent menuActivity = new Intent(more_sportnote.this, menu.class);
                menuActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(menuActivity);
            }
        });

        //On Click moresportmore Button
        moresportmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to more Activity
                Intent moreActivity = new Intent(more_sportnote.this, more.class);
                moreActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moreActivity);
            }
        });

    }
}
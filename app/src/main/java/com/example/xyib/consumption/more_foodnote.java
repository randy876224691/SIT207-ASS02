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

public class more_foodnote extends AppCompatActivity {

    ImageButton morefoodmenu;
    ImageButton morefoodmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_foodnote);

        morefoodmenu = (ImageButton) findViewById(R.id.morefoodmenu);
        morefoodmore = (ImageButton) findViewById(R.id.morefoodmore);
        //On Click bake moresportmenu Button
        morefoodmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to menu Activity
                Intent menuActivity = new Intent(more_foodnote.this, menu.class);
                menuActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(menuActivity);
            }
        });

        //On Click moresportmore Button
        morefoodmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to more Activity
                Intent moreActivity = new Intent(more_foodnote.this, more.class);
                moreActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moreActivity);
            }
        });

    }
}

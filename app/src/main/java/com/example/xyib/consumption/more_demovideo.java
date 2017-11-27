/*

 NAME: Yibing XIE
 ID: 214049532
 for display video

*/

package com.example.xyib.consumption;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class more_demovideo extends AppCompatActivity {

    VideoView myVideoView;
    String webVideoPath = "http://techslides.com/demos/sample-videos/small.mp4";
    String localFilePath;

    ImageButton videotomenu;
    ImageButton videotomore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_demovideo);

        localFilePath = "android.resource://" + getPackageName() + "/" + R.raw.sample;

        videotomenu = (ImageButton) findViewById(R.id.videotomenu);
        videotomore = (ImageButton) findViewById(R.id.videotomore);
        //On Click bake moresportmenu Button
        videotomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to menu Activity
                Intent menuActivity = new Intent(more_demovideo.this, menu.class);
                menuActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(menuActivity);
            }
        });

        //On Click moresportmore Button
        videotomore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get to more Activity
                Intent moreActivity = new Intent(more_demovideo.this, more.class);
                moreActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moreActivity);
            }
        });
    }

    public void playLocalVideo(View view)
    {
        VideoView myVideoView = (VideoView)findViewById(R.id.videoView);
        myVideoView.setVideoURI(Uri.parse(localFilePath));
        myVideoView.setMediaController(new MediaController(this));
        myVideoView.start();
    }
}

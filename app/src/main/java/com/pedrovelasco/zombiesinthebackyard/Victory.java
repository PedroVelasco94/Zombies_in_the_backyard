package com.pedrovelasco.zombiesinthebackyard;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Victory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        VideoView videoView = (VideoView)findViewById(R.id.videoView);


        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.fin);
        videoView.setVideoURI(video);

        videoView.start();


    }
}

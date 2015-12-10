package com.pedrovelasco.zombiesinthebackyard;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Victory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        VideoView videoView = (VideoView)findViewById(R.id.videoView);


        videoView.setVideoPath("/sdcard/Librojuego.mp4");

        videoView.start();


    }
}

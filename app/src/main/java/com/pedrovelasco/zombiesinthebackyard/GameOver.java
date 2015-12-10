package com.pedrovelasco.zombiesinthebackyard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }

    public void restart(View view){

        try {
            Class<?> clase = Class.forName("com.pedrovelasco.zombiesinthebackyard.MainActivity");
            Intent main = new Intent(this, clase);
            startActivity(main);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}

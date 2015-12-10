package com.pedrovelasco.zombiesinthebackyard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Howto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howto);
    }


    public void pulsarHowto(View view){

        try {
            Class<?> clase = Class.forName("com.pedrovelasco.zombiesinthebackyard.MainActivity");
            Intent i = new Intent(this, clase);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}

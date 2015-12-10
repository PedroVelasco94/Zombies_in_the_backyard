package com.pedrovelasco.zombiesinthebackyard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class zombiesLanzar extends AppCompatActivity {

     int ndados;
     int wins = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombies_lanzar);
        setUp();

    }


     public void setUp(){


         TextView d1 = (TextView) findViewById(R.id.d1z);
         TextView d2 = (TextView) findViewById(R.id.d2z);
         TextView d3 = (TextView) findViewById(R.id.d3z);
         TextView d4 = (TextView) findViewById(R.id.d4z);


         ndados = getIntent().getExtras().getInt("NDados");
         Log.d("pz", String.valueOf(ndados));


         switch(ndados){
             case 4:
                 d1.setText(String.valueOf(randomDice()));
                 d2.setText(String.valueOf(randomDice()));
                 d3.setText(String.valueOf(randomDice()));
                 d4.setText(String.valueOf(randomDice()));
                 break;

             case 3:
                 d1.setText(String.valueOf(randomDice()));
                 d2.setText(String.valueOf(randomDice()));
                 d3.setText(String.valueOf(randomDice()));
                 d4.setVisibility(View.INVISIBLE);

                 break;
             case 2:
                 d1.setText(String.valueOf(randomDice()));
                 d2.setText(String.valueOf(randomDice()));
                 d3.setVisibility(View.INVISIBLE);
                 d4.setVisibility(View.INVISIBLE);

                 break;

             case 1:
                 d1.setText(String.valueOf(randomDice()));
                 d2.setVisibility(View.INVISIBLE);
                 d3.setVisibility(View.INVISIBLE);
                 d4.setVisibility(View.INVISIBLE);
                 break;
         }

         Log.d("pz", d1.getText().toString());
         if( Integer.parseInt( d1.getText().toString() ) >= 3){
            wins++;
         }

         if(Integer.parseInt(d2.getText().toString()) >= 3){
             wins++;
         }
         if(Integer.parseInt(d3.getText().toString()) >= 3){
             wins++;
         }
         if(Integer.parseInt(d4.getText().toString()) >= 3){
             wins++;
         }

         Log.d("pz","dados ganados"+String.valueOf(wins));


    }



    public void pulsarZ(View view){
        try {
            Class<?> clase = Class.forName("com.pedrovelasco.zombiesinthebackyard.principal");
            Intent i = new Intent(this, clase);
            i.putExtra("winsZ",wins);
            i.putExtra("fin", true);

            setResult(RESULT_OK, i);
            finish();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public int randomDice(){
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(6);
        return randomNumber + 1;
    }
}

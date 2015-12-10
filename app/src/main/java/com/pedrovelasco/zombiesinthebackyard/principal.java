package com.pedrovelasco.zombiesinthebackyard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class principal extends AppCompatActivity {


    int actZombies = 2;
    int actBarrac = 10;
    int actRepair = 0;

    int winsZ;
    int winsB;
    int winsR;
    boolean finishZ;
    boolean  finishB;
    boolean finishR;
    boolean zombieS;
    boolean BarriS;
    boolean RepairS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        TextView lblZombiesT = (TextView) findViewById(R.id.countZ);
        TextView lblBarricadasT = (TextView) findViewById(R.id.countB);
        TextView lblCocheT = (TextView) findViewById(R.id.countC);

        lblZombiesT.setText(String.valueOf(actZombies));
        lblBarricadasT.setText(String.valueOf(actBarrac));
        lblCocheT.setText(String.valueOf(actRepair));


    }

    public void comenzarRonda(View view) {

        int NDadosZ = 0;
        int NDadosB = 0;
        int NDadosR = 0;
        winsB = 0;
        winsZ = 0;
        winsR = 0;
        int totalDados = 4;

        zombieS = true;
        BarriS = true;
        RepairS = true;

        finishZ = false;
        finishB = false;
        finishR = false;

        RadioButton rbz4 = (RadioButton) findViewById(R.id.rbZ4);
        RadioButton rbz3 = (RadioButton) findViewById(R.id.rbZ3);
        RadioButton rbz2 = (RadioButton) findViewById(R.id.rbZ2);
        RadioButton rbz1 = (RadioButton) findViewById(R.id.rbZ1);
        RadioButton rbz0 = (RadioButton) findViewById(R.id.rbZ0);


        RadioButton rbb4 = (RadioButton) findViewById(R.id.rbB4);
        RadioButton rbb3 = (RadioButton) findViewById(R.id.rbB3);
        RadioButton rbb2 = (RadioButton) findViewById(R.id.rbB2);
        RadioButton rbb1 = (RadioButton) findViewById(R.id.rbB1);
        RadioButton rbb0 = (RadioButton) findViewById(R.id.rbB0);

        RadioButton rbc4 = (RadioButton) findViewById(R.id.rbC4);
        RadioButton rbc3 = (RadioButton) findViewById(R.id.rbC3);
        RadioButton rbc2 = (RadioButton) findViewById(R.id.rbC2);
        RadioButton rbc1 = (RadioButton) findViewById(R.id.rbC1);
        RadioButton rbc0 = (RadioButton) findViewById(R.id.rbC0);



        // COMPROBAR LOS RADIO DE ZOMBIES
        if (rbz4.isChecked()) {
            totalDados -= 4;
            NDadosZ = 4;
        }
        if (rbz3.isChecked()) {
            totalDados -= 3;
            NDadosZ = 3;
        }
        if (rbz2.isChecked()) {
            totalDados -= 2;
            NDadosZ = 2;
        }
        if (rbz1.isChecked()) {
            totalDados -= 1;
            NDadosZ = 1;
        }
        if (rbz0.isChecked()) zombieS = false;


        // COMPROBAR LOS RADIOS DE BARRICADA
        if (rbb4.isChecked()){
            totalDados -= 4;
            NDadosB = 4;
        }
        if (rbb3.isChecked()){
            totalDados -= 3;
            NDadosB = 3;
        }
        if (rbb2.isChecked()){
            totalDados -= 2;
            NDadosB = 2;
        }
        if (rbb1.isChecked()){
            totalDados -= 1;
            NDadosB = 1;
        }
        if (rbb0.isChecked()) BarriS = false;


        // COMPROBAR LOS RADIOS DE REPARAR
        if (rbc4.isChecked()){
            totalDados -= 4;
            NDadosR = 4;
        }
        if (rbc3.isChecked()){
            totalDados -= 3;
            NDadosR = 3;
        }
        if (rbc2.isChecked()){
            totalDados -= 2;
            NDadosR = 2;
        }
        if (rbc1.isChecked()){
            totalDados -= 1;
            NDadosR = 1;
        }
        if (rbc0.isChecked()) RepairS = false;


        Log.d("Valor de dados", String.valueOf(totalDados));

        if (totalDados == 0) {






            //EN CASO DE QUE ZOMBIES TENGA ALGUN PUNTO DE TIRADA
            if (zombieS) {
                try {
                    Class<?> clase = Class.forName("com.pedrovelasco.zombiesinthebackyard.zombiesLanzar");
                    Intent i = new Intent(this, clase);
                    i.putExtra("NDados", NDadosZ);

                    startActivityForResult(i, 2);




                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }







            // EN CASO DE QUE BARRICADAS TENGA ALGUN PUNTO DE TIRADA
            if(BarriS){

                try {
                    Class<?>   clase2 = Class.forName("com.pedrovelasco.zombiesinthebackyard.BarricadasLanzar");
                    Intent i2 = new Intent(this, clase2);

                    i2.putExtra("NDados", NDadosB);
                    startActivityForResult(i2, 3);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }





            //EN CASO DE QUE REPARAR TENGA ALGUN PUNTO
            if(RepairS){

                try {
                    Class<?>   clase3 = Class.forName("com.pedrovelasco.zombiesinthebackyard.RepararLanzar");
                    Intent i3 = new Intent(this, clase3);

                    i3.putExtra("NDados", NDadosR);
                    startActivityForResult(i3, 4);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }


            // FIN DE LOS INTENTS Y YA TODA LA INFORMACION DE LOS DADOS COGIDA









        // EN CASO DEL QUE NUEMERO DE SELECCIONADOS SEA MAYOR O MENOS DE 4
        } else {
            Toast.makeText(this, "El numero de seleccionados tiene que ser 4", Toast.LENGTH_LONG).show();


        }


    }

    public void statusReport(){
        Log.d("resul", "zombies " + actZombies);
        Log.d("resul", "vida "+actBarrac);
        Log.d("resul", "repair "+actRepair);

    }

    public void damageZombies(){
        actBarrac -= actZombies;
    }

    public void rBarrac(){
        Log.d("general", "actualizacoion barracs(Comprobacion gameover)");
        // EN CASO DE QUE NO QUEDEN MAS BARRICADAS(FIN DE JUEGO)


        if(actBarrac <= 0){

            try {
                Class<?>  clase = Class.forName("com.pedrovelasco.zombiesinthebackyard.GameOver");

                Intent gameover = new Intent(this, clase);
                startActivity(gameover);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            TextView lblBarracT = (TextView) findViewById(R.id.countB);
            lblBarracT.setText(String.valueOf(actBarrac));
        }
    }




    public void actZombiesRlvl(){
        Log.d("general", "actualizar zombies");
        /*


             SUMA DE CANTIDAD DE ZOOMBIES SEGUN EL NIVEL DE REPARACION
             hasta 3 un zombies
             entre 3 y 6 dos zombies
             entre 6 y 8 tres zombies
             entre 8 y 10 cuatro zombies

              */
        TextView lblZombiesT = (TextView) findViewById(R.id.countZ);
        TextView lblLvl = (TextView) findViewById(R.id.lblLvl);

        if(0 <= actRepair && actRepair <= 3){
            actZombies += 1;
            lblLvl.setText("+1");
        }
        if(3 < actRepair && actRepair <= 6){
            actZombies += 2;
            lblLvl.setText("+2");
        }
        if(6 < actRepair && actRepair <= 8){
            actZombies += 3;
            lblLvl.setText("+3");
        }
        if(8 < actRepair && actRepair <= 10){
            actZombies += 4;
            lblLvl.setText("+4");
        }


        lblZombiesT.setText(String.valueOf(actZombies));


    }

    public void isvictori(){
        Log.d("general", "victoria");
        if(actRepair >= 10){
            try {
                Class<?>  clase = Class.forName("com.pedrovelasco.zombiesinthebackyard.Victory");
                Intent victory = new Intent(this, clase);
                startActivity(victory);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            rBarrac();

        }
        TextView lblRepair = (TextView) findViewById(R.id.countC);
        lblRepair.setText(String.valueOf(actRepair));

    }









    protected void onActivityResult(int requestCode, int resultCode, Intent data) {




        // INTENT DE ZOMBIES
        if (requestCode == 2) {

            if (resultCode == RESULT_OK) {

                winsZ = data.getIntExtra("winsZ", 0);
                finishZ = data.getBooleanExtra("fin",true);

                Log.d("ganados", "Dados ganados zombies:  " + winsZ);


                actZombies -= winsZ;

            if(actZombies <= 0)actZombies = 0;


              }
            }
            // FIN DE RETORNO DE LA PANTALLA DE ZOMBIES







            //RETORNO DE LA PANTALLA DE BARRICADA
            if(requestCode == 3){
                if(resultCode == RESULT_OK){

                    winsB = data.getIntExtra("winsB", 0);
                    finishB = data.getBooleanExtra("fin", true);

                    Log.d("ganados", "Dados ganados BARRICADAS:  " + winsB);

                    actBarrac += winsB;

                    if(actBarrac >= 10 )actBarrac = 10;

                    TextView lblBarract = (TextView) findViewById(R.id.countB);
                    lblBarract.setText(String.valueOf(actBarrac));



                }

            }

            //FIN DE RETORNO DE LA PANTALLA DE BARRICADA

            //RETORNO DE LA PANTALLA DE ARREGLAR

            if(requestCode == 4){
                if(resultCode == RESULT_OK){
                    winsR = data.getIntExtra("winsR", 0);
                    finishR = data.getBooleanExtra("fin", true);

                    Log.d("ganados", "Dados ganados REPAIRS:  " + winsR);

                    actRepair += winsR;



                }
            }

            //COMPROBACION FINAL INTENS

            if(zombieS && !BarriS && !RepairS && finishZ){
                isvictori();
                damageZombies();
                actZombiesRlvl();
                statusReport();
            }
            if(!zombieS && BarriS && !RepairS && finishB){
                isvictori();
                damageZombies();
                actZombiesRlvl();
                statusReport();
            }
            if(!zombieS && !BarriS && RepairS && finishR){
                isvictori();
                damageZombies();
                actZombiesRlvl();
                statusReport();
            }


            if(zombieS && BarriS && !RepairS && finishZ && finishB && !finishR){
                isvictori();
                damageZombies();
                actZombiesRlvl();
                statusReport();
            }

            if(zombieS && RepairS && !BarriS && finishZ && finishR && !finishB){
                isvictori();
                damageZombies();
                actZombiesRlvl();
                statusReport();
            }

            if(BarriS && RepairS && !zombieS && finishB && finishR && !finishZ){
                isvictori();
                damageZombies();

                actZombiesRlvl();
                statusReport();
            }

            if(zombieS && BarriS && RepairS
               && finishZ && finishB && finishR){
                isvictori();
                damageZombies();

                actZombiesRlvl();
                statusReport();

            }





        }


    }

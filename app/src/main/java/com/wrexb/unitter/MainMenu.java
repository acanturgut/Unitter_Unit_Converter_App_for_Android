package com.wrexb.unitter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Vibrator;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MainMenu extends Activity {

    ImageButton tempbutton;
    ImageButton timebutton;
    ImageButton pressurebutton;
    ImageButton forcebutton;
    ImageButton settingbutton;
    ImageButton powerbutton;
    ImageButton energybutton;
    ImageButton lengthbutton;
    ImageButton weightbutton;
    private Vibrator vibrator;
    boolean isPressed = true;

    String readFile;
    String decimalSize;
    String language1;

    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        try {
            BufferedReader rd = new BufferedReader(new FileReader("/data/data/com.wrexb.unitter/files/user_settings.txt"));

            Log.d("Settings", "file i bulduuuuuuuu  --  - -- - buldu ");


            while (true) {
                break;
            }

            readFile = rd.readLine();

            String[] parts = readFile.split(" ");
            decimalSize = parts[0];
            language1 = parts[1];



            Log.d("Settings", "file i bulduuuuuuuu  --  - -- - buldu " + readFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();


            Log.d("Settings", "file i bulamadi");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Settings", "file i bulamadi");

        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tempbutton=(ImageButton)findViewById(R.id.tempbutton);
        timebutton=(ImageButton)findViewById(R.id.timebutton);
        pressurebutton=(ImageButton)findViewById(R.id.pressurebutton);
        forcebutton=(ImageButton)findViewById(R.id.forcebutton);
        settingbutton=(ImageButton)findViewById(R.id.settingbutton);
        powerbutton=(ImageButton)findViewById(R.id.powerbutton);
        energybutton=(ImageButton)findViewById(R.id.energybutton);
        lengthbutton=(ImageButton)findViewById(R.id.lengthbutton);
        weightbutton=(ImageButton)findViewById(R.id.weightbutton);

        tempbutton.setBackgroundResource(R.drawable.temperature);
        timebutton.setBackgroundResource(R.drawable.time);
        pressurebutton.setBackgroundResource(R.drawable.pressures);
        forcebutton.setBackgroundResource(R.drawable.force);
        settingbutton.setBackgroundResource(R.drawable.setting);
        powerbutton.setBackgroundResource(R.drawable.powers);
        energybutton.setBackgroundResource(R.drawable.energy);
        lengthbutton.setBackgroundResource(R.drawable.rules);
        weightbutton.setBackgroundResource(R.drawable.weight);

        //Backgrounde change of main menu icons



        tempbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

                    if(language1.equals("English")) {

                    tempbutton.setBackgroundResource(R.drawable.temperaturechange);
                    Log.d("dddddd", "UPPP");

                    }else if (language1.equals("Türkçe")){

                        tempbutton.setBackgroundResource(R.drawable.temperature_tr);
                        Log.d("uuuuu", "DOWNN");


                    }else if(language1.equals("Deutsch")){
                        tempbutton.setBackgroundResource(R.drawable.temperaturegr);
                        Log.d("uuuuu", "DOWNN");



                    }

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {


                        tempbutton.setBackgroundResource(R.drawable.temperature);
                        Log.d("uuuuu", "DOWNN");




                }
                return false;
            }
        });

        timebutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

                    if(language1.equals("English")){
                        timebutton.setBackgroundResource(R.drawable.timechange);
                        Log.d("dddddd", "UPPP");
                    }else if(language1.equals("Türkçe")){
                        timebutton.setBackgroundResource(R.drawable.timetr);

                    }else if(language1.equals("Deutsch")){
                        timebutton.setBackgroundResource(R.drawable.timegr);
                    }

                }else if(event.getAction() == android.view.MotionEvent.ACTION_UP){
                    timebutton.setBackgroundResource(R.drawable.time);
                    Log.d("uuuuu","DOWNN");
                }
                return false;
            }
        });

        pressurebutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    if(language1.equals("English")){
                    pressurebutton.setBackgroundResource(R.drawable.pressurechange);
                    Log.d("dddddd", "UPPP");
                    }else if(language1.equals("Türkçe")){
                    pressurebutton.setBackgroundResource(R.drawable.pressuretr);

                    }else if(language1.equals("Deutsch")){
                        pressurebutton.setBackgroundResource(R.drawable.pressuregr);
                    }


                }else if(event.getAction() == android.view.MotionEvent.ACTION_UP){
                    pressurebutton.setBackgroundResource(R.drawable.pressures);
                    Log.d("uuuuu","DOWNN");
                }
                return false;
            }
        });

        forcebutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    if(language1.equals("English")){
                    forcebutton.setBackgroundResource(R.drawable.forcechange);
                    Log.d("dddddd", "UPPP");
                }else if(language1.equals("Türkçe")){
                    forcebutton.setBackgroundResource(R.drawable.forcetr);

                }else if(language1.equals("Deutsch")){
                        forcebutton.setBackgroundResource(R.drawable.forcegr);
                    }


                }else if(event.getAction() == android.view.MotionEvent.ACTION_UP){
                    forcebutton.setBackgroundResource(R.drawable.force);
                    Log.d("uuuuu","DOWNN");
                }
                return false;
            }
        });

        settingbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    if(language1.equals("English")){
                    settingbutton.setBackgroundResource(R.drawable.settingschange);
                    Log.d("dddddd", "UPPP");
                }else if(language1.equals("Türkçe")){
                    settingbutton.setBackgroundResource(R.drawable.settingstr);

                }else if(language1.equals("Deutsch")){
                        settingbutton.setBackgroundResource(R.drawable.settingsgr);
                    }



                }else if(event.getAction() == android.view.MotionEvent.ACTION_UP){
                    settingbutton.setBackgroundResource(R.drawable.setting);
                    Log.d("uuuuu","DOWNN");
                }
                return false;
            }
        });

        powerbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    if(language1.equals("English")){
                    powerbutton.setBackgroundResource(R.drawable.powerchange);
                    Log.d("dddddd", "UPPP");
                }else if(language1.equals("Türkçe")){
                    powerbutton.setBackgroundResource(R.drawable.powertr);

                }else if(language1.equals("Deutsch")){
                        powerbutton.setBackgroundResource(R.drawable.powergr);
                    }


                }else if(event.getAction() == android.view.MotionEvent.ACTION_UP){
                    powerbutton.setBackgroundResource(R.drawable.powers);
                    Log.d("uuuuu","DOWNN");
                }
                return false;
            }
        });


        energybutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    if(language1.equals("English")){
                    energybutton.setBackgroundResource(R.drawable.energychange);
                    Log.d("dddddd", "UPPP");
                }else if(language1.equals("Türkçe")){
                    energybutton.setBackgroundResource(R.drawable.energytr);

                }else if(language1.equals("Deutsch")){
                        energybutton.setBackgroundResource(R.drawable.energygr);
                    }


                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    energybutton.setBackgroundResource(R.drawable.energy);
                    Log.d("uuuuu", "DOWNN");
                }
                return false;
            }
        });

        lengthbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

                    if(language1.equals("English")){
                    lengthbutton.setBackgroundResource(R.drawable.lengthchange);
                    Log.d("dddddd", "UPPP");
                }else if(language1.equals("Türkçe")){
                    lengthbutton.setBackgroundResource(R.drawable.length_tr);

                }else if(language1.equals("Deutsch")){
                        lengthbutton.setBackgroundResource(R.drawable.lengthgr);
                    }


                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    lengthbutton.setBackgroundResource(R.drawable.rules);
                    Log.d("uuuuu", "DOWNN");
                }
                return false;
            }
        });

        weightbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    if(language1.equals("English")){
                    weightbutton.setBackgroundResource(R.drawable.weightchange);
                    Log.d("dddddd", "UPPP");
                }else if(language1.equals("Türkçe")){
                    weightbutton.setBackgroundResource(R.drawable.weighttr);

                }else if(language1.equals("Deutsch")){
                        weightbutton.setBackgroundResource(R.drawable.weightgr);
                    }


                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    weightbutton.setBackgroundResource(R.drawable.weight);
                    Log.d("uuuuu", "DOWNN");
                }
                return false;
            }
        });

        // click event list ***********************
        // click event list ***********************
        // click event list ***********************
        // click event list ***********************
        // click event list ***********************


        tempbutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=TEMPERATURE;
                intent.putExtra("a",a);
                startActivity(intent);


            }
        });
        timebutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=TIME;
                intent.putExtra("a",a);
                startActivity(intent);

            }
        });
        pressurebutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=PRESSURE;
                intent.putExtra("a",a);
                startActivity(intent);

            }
        });
        forcebutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=FORCE;
                intent.putExtra("a",a);
                startActivity(intent);

            }
        });

        powerbutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=POWER;
                intent.putExtra("a",a);
                startActivity(intent);

            }
        });
        energybutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=ENERGY;
                intent.putExtra("a",a);
                startActivity(intent);

            }
        });
        lengthbutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a=LENGTH;
                intent.putExtra("a",a);
                startActivity(intent);

            }
        });
        weightbutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, converter_to_choice.class);
                a = WEIGHT;
                intent.putExtra("a", a);
                startActivity(intent);

            }
        });
        settingbutton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Settings.class);
                a = SETTINGS;
                intent.putExtra("a", a);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static final int LENGTH = 2;
    public static final int FORCE = 5;
    public static final int TEMPERATURE = 1;
    public static final int WEIGHT = 3;
    public static final int PRESSURE = 4;
    public static final int POWER = 6;
    public static final int ENERGY = 7;
    public static final int TIME = 8;
    public static final int SETTINGS = 0;

}

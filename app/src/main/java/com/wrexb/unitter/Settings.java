package com.wrexb.unitter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Settings extends Activity {

    String decimalSize;
    String language1;
    String readFile;
    Spinner languageSpinner1;
    ArrayAdapter<CharSequence> language;
    BufferedWriter settings;
    Button goBack;
    Button save;
    Button restore;

    SeekBar decimalSet;

    TextView title;
    TextView decimal;
    TextView languageText;
    TextView decimalNummber;

    int dec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/abc.TTF");

        decimalSet = (SeekBar) findViewById(R.id.decimalSet);

        title = (TextView) findViewById(R.id.title);
        decimal = (TextView) findViewById(R.id.title_decimal);
        languageText = (TextView) findViewById(R.id.title_languge);
        decimalNummber = (TextView) findViewById(R.id.decimalNumber);



        languageSpinner1 = (Spinner) findViewById(R.id.language1);
        language = ArrayAdapter.createFromResource(this, R.array.language, R.layout.language_spinner_items);
        languageSpinner1.setAdapter(language);


        save = (Button) findViewById(R.id.save);
        restore = (Button) findViewById(R.id.restore);

        decimalSet.setMax(10);

        title.setTypeface(custom_font);
        decimal.setTypeface(custom_font);
        languageText.setTypeface(custom_font);
        decimalNummber.setTypeface(custom_font);

        save.setTypeface(custom_font);
        restore.setTypeface(custom_font);

        title.setTextSize(30);
        decimal.setTextSize(30);
        languageText.setTextSize(30);
        decimalNummber.setTextSize(30);
        save.setTextSize(18);
        restore.setTextSize(18);


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




        Log.d("dec",decimalSize);
        decimalSet.setProgress(Integer.parseInt(decimalSize));
        decimalNummber.setText("# " + decimalSize);

        dec = Integer.parseInt(decimalSize);

        decimalSet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                dec = decimalSet.getProgress();

                decimalNummber.setText("# " + String.valueOf(dec));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                dec = decimalSet.getProgress();

            }
        });

        languageSpinner1.setSelection(language.getPosition(language1));

        Log.d("Settings", "valuelar decimal Size: " + decimalSize + " language: " + language1);

        languageSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (languageSpinner1.getSelectedItem().toString().equals("English")) {

                    languageText.setText("Language");
                    title.setText("Settings");
                    decimal.setText("Decimal Number");


                    save.setText("SAVE");
                    restore.setText("RESTORE");

                    language1 = "English";


                } else if (languageSpinner1.getSelectedItem().toString().equals("Deutsch")) {

                    languageText.setText("Sprache");
                    title.setText("Einstellungen");
                    decimal.setText("Dezimalzahl");


                    save.setText("SPAREN");
                    restore.setText("Wiederher Stellen");

                    language1 = "Deutsch";


                } else if (languageSpinner1.getSelectedItem().toString().equals("Türkçe")) {


                    languageText.setText("Dil");
                    title.setText("Ayarlar");
                    decimal.setText("Virgül Ayarı");


                    save.setText("KAYDET");
                    restore.setText("VARSAYILAN AYARLAR");

                    language1 = "Türkçe";


                } else if (languageSpinner1.getSelectedItem().toString().equals("Pусский")) {

                    languageText.setText("язык");
                    title.setText("настройки");
                    decimal.setText("десятичное число");


                    save.setText("спасти");
                    restore.setText("восстановление");

                    language1 = "Pусский";
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        save.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        try {
                            settings = new BufferedWriter(new FileWriter("/data/data/com.wrexb.unitter/files/user_settings.txt"));

                            settings.write(String.valueOf(dec) + ' ');
                            settings.write(language1);


                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {

                            try {
                                // Close the writer regardless of what happens...
                                settings.close();
                            } catch (Exception e) {
                            }

                        }


                        Intent intent = new Intent(Settings.this, MainMenu.class);
                        startActivity(intent);
                        finish();


                    }
                });

        restore.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        languageText.setText("Language");
                        title.setText("Settings");
                        decimal.setText("Decimal Number");


                        save.setText("SAVE");
                        restore.setText("RESTORE");

                        language1 = "English";

                        decimalSet.setProgress(1);

                        languageSpinner1.setSelection(0);


                        try {
                            settings = new BufferedWriter(new FileWriter("/data/data/com.wrexb.unitter/files/user_settings.txt"));


                            settings.write(String.valueOf(dec) + ' ');
                            settings.write(language1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                // Close the writer regardless of what happens...
                                settings.close();
                            } catch (Exception e) {
                            }
                        }
                    }
                });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
}

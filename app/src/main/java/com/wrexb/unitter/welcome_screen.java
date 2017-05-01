package com.wrexb.unitter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class welcome_screen extends Activity {

    ArrayAdapter<CharSequence> language;
    Spinner languageSpinner;
    BufferedWriter settings;

    String languageS = "English";

    TextView upTitle;
    TextView middleTitle;
    TextView downTitle;
    TextView tellerTitle;

    File user_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        upTitle = (TextView)findViewById(R.id.upperTitle);
        middleTitle = (TextView)findViewById(R.id.middleTitle);
        downTitle = (TextView)findViewById(R.id.downTitle);
        tellerTitle = (TextView)findViewById(R.id.tellerTittle);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/abc.TTF");

        upTitle.setTypeface(custom_font);
        middleTitle.setTypeface(custom_font);
        downTitle.setTypeface(custom_font);
        tellerTitle.setTypeface(custom_font);

        upTitle.setTextSize(15);
        middleTitle.setTextSize(40);
        downTitle.setTextSize(20);
        tellerTitle.setTextSize(15);

        languageSpinner = (Spinner)findViewById(R.id.language);

        language = ArrayAdapter.createFromResource(this,R.array.language, R.layout.language_spinner_items);

        languageSpinner.setAdapter(language);

        languageSpinner.setSelection(language.getPosition("English"));


        languageS = "English";

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (languageSpinner.getSelectedItem().toString().equals("English")) {

                    middleTitle.setText("Welcome to Unitter");
                    upTitle.setText("You can convert simple units with Unitter");
                    downTitle.setText("Select Language");
                    tellerTitle.setText("Double tap to continue");

                    languageS = "English";


                } else if (languageSpinner.getSelectedItem().toString().equals("Deutsch")) {

                    middleTitle.setText("Wilkommen in Unitter");
                    upTitle.setText("Sie können einfache Einheiten mit Unitter konvertieren");
                    downTitle.setText("Spache auswahlen");
                    tellerTitle.setText("Doppelklicken um fortzusetzen");

                    languageS = "Deutsch";

                } else if (languageSpinner.getSelectedItem().toString().equals("Türkçe")) {

                    middleTitle.setText("Unitter'a Hoş Geldiniz");
                    upTitle.setText("Basit birimleri kolayca unitter ile çevirebilirsiniz.");
                    downTitle.setText("Dil Seçiniz");
                    tellerTitle.setText("Devam etmek için ekrana çift tıklayın");

                    languageS = "Türkçe";


                } else if (languageSpinner.getSelectedItem().toString().equals("Pусский")) {

                    middleTitle.setText("Добро Пожаловать в Юниттер!");
                    upTitle.setText("You can convert simple units with Unitter");
                    downTitle.setText("Выберите язык");
                    tellerTitle.setText("Прикоснитесь 2 раза к экрану, чтобы продолжить");

                    languageS = "Pусский";


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        user_settings = new File(this.getFilesDir() + "/", "user_settings.txt");





        findViewById(R.id.main_layout).setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(getApplication(),new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Log.d("TEST", "onDoubleTap");

                    try {
                        settings = new BufferedWriter(new FileWriter(user_settings));

                        settings.write("3 ");
                        settings.write(languageS);


                    } catch (IOException a) {
                        a.printStackTrace();
                    }finally {

                        try {
                            // Close the writer regardless of what happens...
                            settings.close();
                        } catch (Exception a) {
                        }

                    }

                    Intent intent = new Intent(welcome_screen.this, Animationtips.class);
                    startActivity(intent);
                    finish();

                    return super.onDoubleTap(e);
                }

            });
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TEST", "Raw event: " + event.getAction() + ", (" + event.getRawX() + ", " + event.getRawY() + ")");
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
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

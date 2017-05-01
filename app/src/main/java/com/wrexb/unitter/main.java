package com.wrexb.unitter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class main extends Activity {
    BufferedWriter settings = null;
    BufferedWriter wf = null;
    BufferedReader rd = null;


    String openControl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //reader

        try {
            BufferedReader rd = new BufferedReader(new FileReader("/data/data/com.wrexb.unitter/files/user_log.txt"));

            Log.d("ANAN","file i bulduuuuuuuu  --  - -- - buldu ");

            openControl = rd.readLine();

            while(true){
                break;
            }

            Log.d("ANAN","file i bulduuuuuuuu  --  - -- - buldu " + openControl);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            openControl = "";

            Log.d("ANAN","file i bulamadi");
        } catch (IOException e) {
            e.printStackTrace();
            openControl = "";
        }

        //writer

        File file = new File(this.getFilesDir() + "/","user_log.txt");


        try {
            wf = new BufferedWriter(new FileWriter(file));


            wf.write("dogru");

            Log.d("ANAN", "writer a girdi" + file.getAbsolutePath());

        } catch (IOException e) {
            Log.d("ANAN","writer a girmedi");
            e.printStackTrace();
        }finally {
            try {
                // Close the writer regardless of what happens...
                wf.close();
            } catch (Exception e) {
            }
        }



        int DELAY = 1400;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(openControl.equals("dogru")) {



                    Intent intent = new Intent(main.this, MainMenu.class);
                    startActivity(intent);
                    finish();

                }else {

                    Intent intent = new Intent(main.this, welcome_screen.class);
                    startActivity(intent);
                    finish();

                    }


            }
        }, DELAY);




    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.wrexb.unitter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;




public class Animationtips extends Activity {

    AnimationDrawable tipsAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationtips);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView tipImageText = (ImageView) findViewById(R.id.animation1);
        tipImageText.setBackgroundResource(R.drawable.animation_maker);

        tipsAnimation = (AnimationDrawable) tipImageText.getBackground();

    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ImageView tipImageText = (ImageView) findViewById(R.id.animation1);
        tipImageText.setBackgroundResource(R.drawable.animation_maker);

        tipsAnimation = (AnimationDrawable) tipImageText.getBackground();


        if(hasFocus) {
            tipsAnimation.start();
        } else {
            tipsAnimation.stop();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            tipsAnimation.start();

            Intent intent = new Intent(Animationtips.this, MainMenu.class);
            startActivity(intent);
            finish();


            return true;
        }
        return super.onTouchEvent(event);


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animationtips, menu);
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

package com.wrexb.unitter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.text.DecimalFormat;

public class converter_to_choice extends Activity implements TextWatcher{

    EditText enter;

    TextView sample;
    TextView get;
    TextView end;
    String readFile;
    String decimalSize;
    String language1;
    Button calculate;
    Button clear;

    int settings_decimal;

    ArrayAdapter<CharSequence> adapterfromlength;
    ArrayAdapter<CharSequence> adaptertolength;
    ArrayAdapter<CharSequence> adapterfromtime;
    ArrayAdapter<CharSequence> adaptertotime;
    ArrayAdapter<CharSequence> adapterfromtemp;
    ArrayAdapter<CharSequence> adaptertotemp;
    ArrayAdapter<CharSequence> adapterfrompower;
    ArrayAdapter<CharSequence> adaptertopower;
    ArrayAdapter<CharSequence> adapterfromenergy;
    ArrayAdapter<CharSequence> adaptertoenergy;
    ArrayAdapter<CharSequence> adapterfromweight;
    ArrayAdapter<CharSequence> adaptertoweight;
    ArrayAdapter<CharSequence> adapterfrompressure;
    ArrayAdapter<CharSequence> adaptertopressure;
    ArrayAdapter<CharSequence> adapterfromforce;
    ArrayAdapter<CharSequence> adaptertoforce;

    String eChangerTo;
    String eChangerFrom;

    String textTo;
    String textFrom;

    String enterValue;
    String enterValueWarning;

    DecimalFormat df;
    DecimalFormat ds;

    // Temperature Start

    String Fahrenheit;
    String Celcius;
    String Kelvin;

    // Temperature-Kısaltma

    String Fahrenheit2;
    String Celcius2;
    String Kelvin2;

    RelativeLayout frame;

    Spinner to;
    Spinner from;

    double val;
    double res;
    char c;

    int a;
    private Context activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_to_choice);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        try {
            BufferedReader rd = new BufferedReader(new FileReader("/data/data/com.wrexb.unitter/files/user_settings.txt"));

            Log.d("Settings", "file i bulduuuuuuuu  --  - -- - buldu ");



            while(true){
                break;
            }

            readFile = rd.readLine();



            Log.d("Settings","file i bulduuuuuuuu  --  - -- - buldu " + readFile );

        } catch (FileNotFoundException e) {
            e.printStackTrace();


            Log.d("Settings","file i bulamadi");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Settings", "file i bulamadi");

        }


        String[] parts = readFile.split(" ");
        decimalSize= parts[0];
        language1 = parts[1];

        settings_decimal = Integer.parseInt(decimalSize);




        Fahrenheit = "Fahrenheit";
         Celcius = "Celcius";
         Kelvin = "Kelvin";

        // Temperature-Kısaltma

         Fahrenheit2 = "F";
         Celcius2 = "C";
         Kelvin2 = "K";

        //definiton fnish

        c = '0';

        calculate = (Button)findViewById(R.id.calculate);
        clear=(Button)findViewById(R.id.restore);
        enter = (EditText)findViewById(R.id.enter);
        final Typeface custom_digital = Typeface.createFromAsset(getAssets(),  "fonts/abd.TTF");
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/abc.TTF");
        enter.setTypeface(custom_font);
        enter.setTextSize(35);
        sample=(TextView)findViewById(R.id.sample);

        get=(TextView)findViewById(R.id.get);
        end=(TextView)findViewById(R.id.end);

        end.setTypeface(custom_font);
        get.setTypeface(custom_font);
        sample.setTypeface(custom_font);

        calculate.setTypeface(custom_font);
        clear.setTypeface(custom_font);

        end.setTextSize(30);
        get.setTextSize(30);
        sample.setTextSize(18);

        if(language1.equals("English")){

            calculate.setText("Calcualate");
            clear.setText("Clear");

            get.setText("Your Value");
            end.setText("Result");


            enterValue = "Enter Value";
            enterValueWarning = "Please enter a valid number !";

        }else if(language1.equals("Türkçe")){

            calculate.setText("Hesapla");
            clear.setText("Temizle");

            enterValue = "Bir değer giriniz";
            enterValueWarning = "Geçersiz bir değer girdiniz !";

        }else if(language1.equals("Deutsch")){
            calculate.setText("Berechnen");
            clear.setText("Beseitigen");

            enterValue = "Bir değer giriniz"; // almancası gelicek
            enterValueWarning = "Geçersiz bir değer girdiniz !"; // almancası gelicek

        }else if(language1.equals("Pусский")){
            calculate.setText("вычислять");
            clear.setText("ясно");

            enterValue = "Bir değer giriniz"; // rusçası gelicek
            enterValueWarning = "Geçersiz bir değer girdiniz !"; // rusçası gelicek

        }

        a = getIntent().getIntExtra("a",a);

        to = (Spinner)findViewById(R.id.chooseTo);
        from = (Spinner)findViewById(R.id.chooseFrom);



        adaptertolength = ArrayAdapter.createFromResource(this,R.array.tolength, R.layout.spinner_item);
        adapterfromlength = ArrayAdapter.createFromResource(this,R.array.fromlength, R.layout.spinner_item);
        adapterfromtime = ArrayAdapter.createFromResource(this,R.array.fromtime, R.layout.spinner_item);
        adaptertotime = ArrayAdapter.createFromResource(this,R.array.totime, R.layout.spinner_item);
        adapterfromweight = ArrayAdapter.createFromResource(this,R.array.fromweight, R.layout.spinner_item);
        adaptertoweight = ArrayAdapter.createFromResource(this,R.array.toweight, R.layout.spinner_item);
        adapterfrompressure = ArrayAdapter.createFromResource(this,R.array.frompressure, R.layout.spinner_item);
        adaptertopressure = ArrayAdapter.createFromResource(this,R.array.topressure, R.layout.spinner_item);
        adapterfromforce = ArrayAdapter.createFromResource(this,R.array.fromforce, R.layout.spinner_item);
        adaptertoforce = ArrayAdapter.createFromResource(this,R.array.toforce, R.layout.spinner_item);
        adapterfromtemp = ArrayAdapter.createFromResource(this,R.array.fromtemp,R.layout.spinner_item);
        adaptertotemp = ArrayAdapter.createFromResource(this,R.array.totemp, R.layout.spinner_item);
        adapterfromenergy = ArrayAdapter.createFromResource(this,R.array.fromenergy, R.layout.spinner_item);
        adaptertoenergy = ArrayAdapter.createFromResource(this,R.array.toenergy, R.layout.spinner_item);
        adapterfrompower = ArrayAdapter.createFromResource(this,R.array.frompower, R.layout.spinner_item);
        adaptertopower = ArrayAdapter.createFromResource(this,R.array.topower, R.layout.spinner_item);

        frame = (RelativeLayout)findViewById(R.id.sa);

        frame.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            public void onSwipeTop() {
            }

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onSwipeRight() {
                Intent intent = new Intent(converter_to_choice.this, MainMenu.class);
                startActivity(intent);



            }

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onSwipeLeft() {
                Intent intent = new Intent(converter_to_choice.this, MainMenu.class);
                startActivity(intent);



            }

            public void onSwipeBottom() {
            }

            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });


        //edit text "enter" click
        enter.setText(enterValue);

        enter.setOnClickListener(
                new EditText.OnClickListener() {
                    public void onClick(View v) {

                        if(enter.getText().toString().matches(enterValue)){
                            enter.setText("");
                            enter.setSelection(enter.getText().length());
                            enter.setTypeface(custom_digital);

                        }else{

                        }
                        return;
                    }
                }
        );
        clear.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        enter.setText("");
                    }
                });
        description();
        sex();
    }
    public void sex(){
        calculate.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        if(settings_decimal == 0) {
                            df = new DecimalFormat("#");
                            ds = new DecimalFormat("#");
                        }else if(settings_decimal == 1) {
                            df = new DecimalFormat("#.#E0");
                            ds = new DecimalFormat("#.#");
                        }else if(settings_decimal == 2) {
                            df = new DecimalFormat("#.##E0");
                            ds = new DecimalFormat("#.##");
                     }else if(settings_decimal == 3) {
                            df = new DecimalFormat("#.###E0");
                            ds = new DecimalFormat("#.###");
                     }else if(settings_decimal == 4) {
                         df = new DecimalFormat("#.####E0");
                            ds = new DecimalFormat("#.####");
                     }else if(settings_decimal == 5) {
                         df = new DecimalFormat("#.#####E0");
                            ds = new DecimalFormat("#.#####");
                     } else if(settings_decimal == 6) {
                         df = new DecimalFormat("#.######E0");
                            df = new DecimalFormat("#.######");
                     } else if(settings_decimal == 7) {
                         df = new DecimalFormat("#.#######E0");
                            ds = new DecimalFormat("#.#######");
                     }else if(settings_decimal == 8) {
                         df = new DecimalFormat("#.########E0");
                            ds = new DecimalFormat("#.########");
                     }else if(settings_decimal == 9) {
                         df = new DecimalFormat("#.#########E0");
                            ds = new DecimalFormat("#.#########");
                     }else if(settings_decimal == 10) {
                            df = new DecimalFormat("#.##########E0");
                            ds = new DecimalFormat("#.##########");
                     }else if(settings_decimal == 11) {
                         df = new DecimalFormat("#.###########E0");
                            ds = new DecimalFormat("#.###########");
                     }else if(settings_decimal == 12) {
                         df = new DecimalFormat("#.############E0");
                            ds = new DecimalFormat("#.############");
                     }
                        if (enter.getText().toString().matches(enterValue)) {
                            enter.setText("");

                            final Typeface custom_digital = Typeface.createFromAsset(getAssets(),  "fonts/abd.TTF");

                            enter.setSelection(enter.getText().length());
                            enter.setTypeface(custom_digital);
                        } else {
                            if (enter.getText().toString() == null || enter.getText().toString().trim().equals("")) {
                                Toast.makeText(getApplicationContext(), enterValueWarning,
                                        Toast.LENGTH_SHORT).show();

                            } else if (enter.getText().toString().length() >= 13) {

                            } else if (enter.getText().toString().length() >= 2 && enter.getText().toString().charAt(1) == c && enter.getText().toString().charAt(0) == c) {

                            }else if (new String(Fahrenheit).equals(textFrom) && new String(Fahrenheit).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = val * 1.0;
                                sample.setText("LOL");

                            }else if (new String(Fahrenheit).equals(textFrom) && new String(Celcius).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = (val-32)/1.8;
                                sample.setText("0" + " " + textFrom + " = " + "-17.77" + " " +textTo);

                            }else if (new String(Fahrenheit).equals(textFrom) && new String(Kelvin).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = (val+459.67)/1.8;
                                sample.setText("0" + " " + textFrom + "=" + " 255.3722222 " + " " + textTo);
                            }else if (new String(Celcius).equals(textFrom) && new String(Celcius).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = val * 1.0;
                                sample.setText("LOL");

                            }else if (new String(Celcius).equals(textFrom) && new String(Kelvin).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = val + 273.15;
                                sample.setText("0" + " " + textFrom + " = " + "273.15" + " " + textTo);

                            }else if (new String(Celcius).equals(textFrom) && new String(Fahrenheit).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = ((1.8)*val)+32;
                                sample.setText("0" + " " + textFrom + " = " + "32" + " " + textTo);

                            }else if (new String(Kelvin).equals(textFrom) && new String(Kelvin).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = val * 1.0;
                                sample.setText("LOL");

                            }else if (new String(Kelvin).equals(textFrom) && new String(Fahrenheit).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = ((val-273.12)*1.8)+32;
                                sample.setText("1" + " " + textFrom + " = " + " -459.616 " + " " + textTo);

                            }else if (new String(Kelvin).equals(textFrom) && new String(Celcius).equals(textTo)) {
                                val = Double.parseDouble(enter.getText().toString());
                                res = val - 273.15;
                                sample.setText("0" + " " + textFrom + " = " + "-273.15" + " " + textTo);
                                return;}

                            ShortCuts shortcut = new ShortCuts();
                            textFrom = textFrom.replace('[', '-');
                            textFrom = textFrom.replace('/', '-');
                            textFrom = textFrom.replace(']', '-');
                            textFrom = textFrom.replace(' ','-');
                            textFrom = textFrom.replace('.','-');
                            textTo = textTo.replace('[', '-');
                            textTo = textTo.replace('/', '-');
                            textTo = textTo.replace(']', '-');
                            textTo = textTo.replace(' ','-');
                            textTo = textTo.replace('.','-');

                            textFrom = textFrom.replaceAll("-","");
                            textTo = textTo.replaceAll("-","");

                            switch(a){
                                case MainMenu.LENGTH:
                                    Length length = new Length();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = length.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(length.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;
                                case MainMenu.FORCE:
                                    Force force = new Force();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = force.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(force.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;
                                case MainMenu.TIME:
                                    Time time = new Time();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = time.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(time.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;
                                case MainMenu.WEIGHT:
                                    Weight weight = new Weight();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = weight.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(weight.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;
                                case MainMenu.PRESSURE:
                                    Pressure pressure = new Pressure();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = pressure.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(pressure.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;
                                case MainMenu.ENERGY:
                                    Energy energy = new Energy();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = energy.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(energy.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;
                                case MainMenu.POWER:
                                    Power power = new Power();
                                    if (enter.getText().toString().matches(" ")||enter.getText().toString() == null || enter.getText().toString().trim().equals("")){Toast.makeText(getApplicationContext(), enterValueWarning, Toast.LENGTH_SHORT).show();
                                    }else
                                        val = Double.parseDouble(enter.getText().toString());
                                    res = power.calculate(val, textFrom, textTo);
                                    if(!textFrom.equals(textTo))
                                        sample.setText("1" + " " + textFrom + " = " + df.format(power.getRatio(textFrom, textTo)) + " " + textTo);
                                    break;

                                // diger caseleri buraya siralarsiniz

                                default:
                                    break;
                            }
                            if(textTo.equals(textFrom))
                                sample.setText("LOL");

                            if(val>1000 || val< 0.001) {

                                eChangerFrom = df.format(val);

                                try {
                                    eChangerFrom = eChangerFrom.replaceAll("E", " x 10#");

                                    String[] parts = eChangerFrom.split("#");
                                    String from1 = parts[0];
                                    String from2 = parts[1];

                                    get.setText(from1 + "^" + from2 + " " + shortcut.getShortCutMap().get(textFrom));

                                }catch(Exception e){

                                    get.setText(df.format(val) + " " + shortcut.getShortCutMap().get(textFrom));

                                }


                            }else if(val<= 1000 || val >= 0.001 || val == 0){


                                get.setText(ds.format(val) + " " + shortcut.getShortCutMap().get(textFrom));

                            }

                            if(res>1000 || res< 0.001 ) {

                                eChangerTo =  df.format(res);

                                try {


                                    eChangerTo = eChangerTo.replaceAll("E", " x 10#");

                                    String[] parts = eChangerTo.split("#");
                                    String to1 = parts[0];
                                    String to2 = parts[1];

                                    end.setText(to1 + "^" + to2 + " " + shortcut.getShortCutMap().get(textTo));

                                }catch(Exception e){


                                    end.setText(df.format(res) +" " + shortcut.getShortCutMap().get(textTo));

                                    }

                            }else if(res<= 1000 || res >= 0.001 || res == 0){



                                end.setText(ds.format(res) + " " + shortcut.getShortCutMap().get(textTo));


                            }
                        }


                        InputMethodManager inputManager = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);

                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                });
    }

    // ifler ve adapter choose

    public void description(){

        if(a==MainMenu.LENGTH){to.setAdapter(adaptertolength);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfromlength);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}else if(a==MainMenu.TIME){to.setAdapter(adaptertotime);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfromtime);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}else if(a==MainMenu.TEMPERATURE){to.setAdapter(adaptertotemp);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfromtemp);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}else if(a==MainMenu.PRESSURE){to.setAdapter(adaptertopressure);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfrompressure);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}else if(a==MainMenu.FORCE){to.setAdapter(adaptertoforce);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfromforce);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}else if(a==MainMenu.POWER){to.setAdapter(adaptertopower);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfrompower);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}else if(a==MainMenu.ENERGY){to.setAdapter(adaptertoenergy);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfromenergy);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}
        else if(a==MainMenu.WEIGHT){to.setAdapter(adaptertoweight);
            to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textTo = to.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            from.setAdapter(adapterfromweight);
            from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    textFrom = from.getSelectedItem().toString();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_converter_to_choice, menu);
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable s) {


    }

    public Context getActivity() {
        return activity;
    }
}

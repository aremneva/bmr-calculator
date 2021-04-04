package com.example.bmr_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private EditText height;
    private EditText weight;
    private EditText age;
    private TextView bmr;
    private TextView sid;
    private TextView minact;
    private TextView avgact;
    private TextView strgact;
    private TextView maxact;
    private ImageView imgF;
    private ImageView imgM;
    boolean clickedF=false;
    boolean clickedM=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height  = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        age = (EditText) findViewById(R.id.age);
        bmr  = (TextView) findViewById(R.id.bmr);

        sid= (TextView) findViewById(R.id.sid);
        minact= (TextView) findViewById(R.id.minact);
        avgact= (TextView) findViewById(R.id.avgact);
        strgact= (TextView) findViewById(R.id.strgact);
        maxact= (TextView) findViewById(R.id.maxact);

        imgF=(ImageView) findViewById(R.id.female);
        imgM=(ImageView) findViewById(R.id.male);


    }

    public void clean(View view) {
        sid.setText(getString(R.string.sids));
        minact.setText("Маленькая активность: ");
        avgact.setText("Средняя активность: ");
        strgact.setText("Сильная активность: ");
        maxact.setText("Максимальная активность: ");

        height.setText("");
        weight.setText("");
        age.setText("");
        bmr.setText("");

        imgF.setBackgroundColor(imgF.getResources().getColor(R.color.design_default_color_background));
        imgM.setBackgroundColor(imgF.getResources().getColor(R.color.design_default_color_background));

        clickedF=false;
        clickedM=false;
    }

    public void info(View view) {
        Intent intent = new Intent (this, result.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void count(View view) {
        double w,h,a, bmrI, sidact, min, max,strg,avg ;


        if ((weight.getText().length()==0)||(height.getText().length()==0)||(age.getText().length()==0)){
            Toast toast = Toast.makeText(this, R.string.enter, Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            String S1 = weight.getText().toString();
            String S2 = height.getText().toString();
            String S3 = age.getText().toString();

            w = Double.parseDouble(S1);
            h = Double.parseDouble(S2);
            a = Double.parseDouble(S3);


            if (clickedF) {
                bmrI = Math.round(655 + (9.6 * w) + (1.8 * h) - (4.7 * a));
            } else if (clickedM) {
                bmrI = Math.round(66 + (13.7 * w) + (5 * h) - (6.8 * a));
            } else {
                bmrI = 0;
                Toast toast = Toast.makeText(this, R.string.pol, Toast.LENGTH_LONG);
                toast.show();
            }
            //Для мужчин:	BMR = 66 + (13.7 x вес) + (5 x рост) - (6.8 x возраст)
            //Для женщин:	BMR = 655 + (9.6 x вес) + (1.8 x рост) - (4.7 x возраст)
            String res1 = Double.toString(bmrI);
            bmr.setText(res1);
            sidact = Math.round(bmrI * 1.2);
            min = Math.round(bmrI * 1.375);
            avg = Math.round(bmrI * 1.55);
            strg =Math.round (bmrI * 1.725);
            max = Math.round(bmrI * 1.9);

            sid.setText(getString(R.string.sids)+Double.toString(sidact));
            minact.setText(getString(R.string.mins)+Double.toString(min));
            avgact.setText(getString(R.string.avgs)+Double.toString(avg));
            strgact.setText(getString(R.string.strgs)+Double.toString(strg));
            maxact.setText(getString(R.string.maxs)+Double.toString(max));
            //Сидячий образ 	BMR * 1.2
            //Маленькая активность	BMR * 1.375
            //Средняя активность	BMR * 1.55
            //Сильная активность	BMR * 1.725
            //Максимальная активность	BMR * 1.9
        }

    }

    public void female(View view) {
        clickedF=true;
        clickedM=false;
        imgF.setBackgroundColor(imgF.getResources().getColor(R.color.gray));
        imgM.setBackgroundColor(imgF.getResources().getColor(R.color.design_default_color_background));
    }

    public void male(View view) {
        clickedM=true;
        clickedF=false;
        imgM.setBackgroundColor(imgF.getResources().getColor(R.color.gray));
        imgF.setBackgroundColor(imgF.getResources().getColor(R.color.design_default_color_background));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.eng :
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, null);
                setTitle(R.string.app_name);
                return true;
            case R.id.rus:
                Locale locale1 = new Locale("ru");
                Locale.setDefault(locale1);
                Configuration configuration1 = new Configuration();
                configuration1.locale = locale1;
                getBaseContext().getResources().updateConfiguration(configuration1, null);
                setTitle(R.string.app_name);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void MarafonSkills(MenuItem item) {
        Intent intent = new Intent (this, MarafonSkills.class);
        startActivity(intent);
    }
}
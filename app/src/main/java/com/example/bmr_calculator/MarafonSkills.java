package com.example.bmr_calculator;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarafonSkills extends AppCompatActivity {

    private static final String filename="marathon-skills-2016-marathon-info.txt";
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marafon_skills);

       /* info= (TextView) findViewById(R.id.inf);
        info.setText(getString(R.string.information));*/

    }

    public void newback(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

   /* public void load(View view) {
        FileInputStream fis = null;
        try {
            fis = openFileInput(filename);
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text=br.readLine())!=null){
                sb.append(text).append("\n");
            }

            info.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
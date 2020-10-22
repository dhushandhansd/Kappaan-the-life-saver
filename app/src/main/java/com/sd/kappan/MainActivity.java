package com.sd.kappan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button loinregitxt;
    Button useappbutt;
    TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loinregitxt = (Button) findViewById(R.id.logpageregi);
        loinregitxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterPage.class);
                startActivity(intent);
            }
        });

        Button useappbutt = (Button) findViewById(R.id.loginbutton);
        useappbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainPage.class);
                startActivity(intent);
            }
        });

        TextView about = (TextView) findViewById(R.id.abtus);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AboutusPage.class);
                startActivity(intent);
            }
        });

    }
}

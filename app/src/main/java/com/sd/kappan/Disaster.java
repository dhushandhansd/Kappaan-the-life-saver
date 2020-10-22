package com.sd.kappan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.ACTION_CALL;

public class Disaster extends AppCompatActivity {

    Button os1;
    Button diasateraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);

        final MediaPlayer disaster = MediaPlayer.create(Disaster.this,R.raw.disasteremergency);

        Button os1 = (Button)findViewById(R.id.os7);;
        os1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent us = new Intent(Disaster.this,Menu.class);
                startActivity(us);
            }
        });

        Button disasteraction = (Button)findViewById(R.id.disasteraction);
        disasteraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent up = new Intent(ACTION_CALL);
                up.setData(Uri.parse("tel:01124363260"));
                startActivity(up);
                disaster.start();

                Toast.makeText(Disaster.this,"Calling Disaster Emergency",Toast.LENGTH_LONG).show();
                
            }
        });


    }
}

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

public class AmbulanceTN extends AppCompatActivity {

    Button servamb;
    Button ambtnaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_tn);

        final MediaPlayer ambulancetn = MediaPlayer.create(AmbulanceTN.this,R.raw.ambulance);

        Button servamb = (Button) findViewById(R.id.ohersrv);
        servamb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ots = new Intent(AmbulanceTN.this,Menu.class);
                startActivity(ots);
            }
        });

        Button ambtnaction = (Button) findViewById(R.id.ambutnaction);
        ambtnaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tn = new Intent(ACTION_CALL);
                tn.setData(Uri.parse("tel:108"));
                startActivity(tn);
                ambulancetn.start();

                Toast.makeText(AmbulanceTN.this, "Calling Ambulance", Toast.LENGTH_LONG).show();
            }
        });
    }
}

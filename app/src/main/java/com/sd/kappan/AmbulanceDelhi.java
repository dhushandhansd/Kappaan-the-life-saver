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

public class AmbulanceDelhi extends AppCompatActivity {

    Button otherserv;
    Button Ambuactio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_delhi);

        final MediaPlayer ambulancend = MediaPlayer.create(AmbulanceDelhi.this,R.raw.ambulance);

        Button otherserv = (Button) findViewById(R.id.servbutt1);
        otherserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ambuldel = new Intent(AmbulanceDelhi.this,Menu.class);
                startActivity(ambuldel);

            }
        });

        Button Ambuactio = (Button) findViewById(R.id.ambulanceaction);
        Ambuactio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ambactio = new Intent(ACTION_CALL);
                ambactio.setData(Uri.parse("tel:102"));
                startActivity(ambactio);
                ambulancend.start();

                Toast.makeText(AmbulanceDelhi.this,"Calling Ambulance",Toast.LENGTH_LONG).show();
            }
        });
    }
}

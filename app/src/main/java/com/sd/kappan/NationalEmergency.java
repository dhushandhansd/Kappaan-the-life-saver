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

public class NationalEmergency extends AppCompatActivity {

    Button ohs;
    Button natemgaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_emergency);

        final MediaPlayer national = MediaPlayer.create(NationalEmergency.this,R.raw.nationalemergency);

        Button ohs = (Button)findViewById(R.id.ohsebutt);
        ohs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ola = new Intent(NationalEmergency.this,Menu.class);
                startActivity(ola);
            }
        });

        Button nateemgaction = (Button)findViewById(R.id.natemgaction);
        nateemgaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ola1 = new Intent(ACTION_CALL);
                ola1.setData(Uri.parse("tel:112"));
                startActivity(ola1);
                national.start();

                Toast.makeText(NationalEmergency.this,"Calling National Emergency",Toast.LENGTH_LONG).show();
            }
        });
    }
}

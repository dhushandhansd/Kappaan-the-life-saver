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

public class Fire extends AppCompatActivity {

    Button os;
    Button fireactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        final MediaPlayer firesound = MediaPlayer.create(Fire.this,R.raw.fireservice);

        Button os = (Button)findViewById(R.id.os);
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent osp = new Intent(Fire.this,Menu.class);
                startActivity(osp);
            }
        });

        Button fireactions = (Button)findViewById(R.id.fireaction);
        fireactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fs = new Intent(ACTION_CALL);
                fs.setData(Uri.parse("tel:101"));
                startActivity(fs);
                firesound.start();

                Toast.makeText(Fire.this,"Calling Fire Service",Toast.LENGTH_LONG).show();
                
            }
        });
    }
}

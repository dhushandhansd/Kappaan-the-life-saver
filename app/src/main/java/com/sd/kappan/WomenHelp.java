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

public class WomenHelp extends AppCompatActivity {

    Button otser;
    Button action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_help);

        final MediaPlayer women = MediaPlayer.create(WomenHelp.this,R.raw.womenhelpline);

        Button otser = (Button) findViewById(R.id.wobutt);
        otser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(WomenHelp.this,Menu.class);
                startActivity(act);
            }
        });

        Button action = (Button) findViewById(R.id.actionbutt);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ac = new Intent(ACTION_CALL);
                ac.setData(Uri.parse("tel:1091"));
                startActivity(ac);
                women.start();
                Toast.makeText(WomenHelp.this,"Calling Women Helpline",Toast.LENGTH_LONG).show();
            }
        });


    }
}

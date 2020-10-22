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

public class Poison extends AppCompatActivity {

    Button oas6;
    Button poisonaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poison);

        final MediaPlayer poisonso = MediaPlayer.create(Poison.this,R.raw.antipoison);

        Button oas6 = (Button)findViewById(R.id.os6);
        oas6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent txtpois = new Intent(Poison.this,Menu.class);
                startActivity(txtpois);
            }
        });

        Button poisonaction = (Button)findViewById(R.id.poisonactin);
        poisonaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent poison = new Intent(ACTION_CALL);
                poison.setData(Uri.parse("tel:1066"));
                startActivity(poison);
                poisonso.start();

                Toast.makeText(Poison.this,"Calling Anti Poison Emergency",Toast.LENGTH_LONG).show();

            }
        });
    }
}

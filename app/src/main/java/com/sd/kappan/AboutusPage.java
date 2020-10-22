package com.sd.kappan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutusPage extends AppCompatActivity {

    Button bckbytt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus_page);

        Button bckbytt = (Button) findViewById(R.id.bkbutt);
        bckbytt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutusPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}

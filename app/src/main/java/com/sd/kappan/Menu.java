package com.sd.kappan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button Women;
    Button Child;
    Button AmbDel;
    Button AmbTn;
    Button NatEmg;
    Button Fire;
    Button Disaster;
    Button Poison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_menu);

        Button Women = (Button) findViewById(R.id.button0);
        Women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wom = new Intent(Menu.this,WomenHelp.class);
                startActivity(wom);
            }
        });

        Button Child = (Button) findViewById(R.id.button1);
        Child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chi = new Intent(Menu.this,ChildHelpline.class);
                startActivity(chi);
            }
        });

        Button AmbDel = (Button) findViewById(R.id.button2);
        AmbDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ambdel = new Intent(Menu.this,AmbulanceDelhi.class);
                startActivity(ambdel);
            }
        });

        Button AmbTn = (Button) findViewById(R.id.button3);
        AmbTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ambtn = new Intent(Menu.this,AmbulanceTN.class);
                startActivity(ambtn);
            }
        });

        Button NatEmg = (Button) findViewById(R.id.button4);
        NatEmg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent natemg = new Intent(Menu.this,NationalEmergency.class);
                startActivity(natemg);
            }
        });

        Button Fire = (Button)findViewById(R.id.button5);
        Fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fire = new Intent(Menu.this, Fire.class);
                startActivity(fire);
            }
        });

        Button Disaster = (Button)findViewById(R.id.button7);
        Disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disaster = new Intent(Menu.this,Disaster.class);
                startActivity(disaster);
            }
        });

        final Button Poison = (Button)findViewById(R.id.button6);
        Poison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent poison = new Intent(Menu.this,Poison.class);
                startActivity(poison);
            }
        });

    }
}

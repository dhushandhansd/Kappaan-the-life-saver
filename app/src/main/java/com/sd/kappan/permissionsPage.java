package com.sd.kappan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

import java.util.Timer;
import java.util.TimerTask;

public class permissionsPage extends AppCompatActivity {

    Button go;
    Button accpt;
    Button decl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_page);

        Button go = (Button)findViewById(R.id.gobutton);
        Button accpt = (Button)findViewById(R.id.acceptbutt);
        Button decl = (Button)findViewById(R.id.declinebutt);

        accpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goin = new Intent(permissionsPage.this,MainPage.class);
                startActivity(goin);

            }
        });

        decl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(permissionsPage.this, "The App will not Work Properly unless you Accept the Permissions", Toast.LENGTH_SHORT).show();
            }
        });



        Toast.makeText(permissionsPage.this,"Tap GO to use the App After Granting Permissions",Toast.LENGTH_LONG).show();


    }

}

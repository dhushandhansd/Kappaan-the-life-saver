package com.sd.kappan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.security.Permission;

import static com.sd.kappan.R.layout.activity_main_page;


public class MainPage extends AppCompatActivity {

    Button custombutton;
    Button mainpgsignup;
    Button othrservice;
    Button myLocation;

    public MediaPlayer siren;

    public int REQUEST_CODE = 1234;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main_page);

        permissions();

        final MediaPlayer policesiren = MediaPlayer.create(MainPage.this, R.raw.police_siren);

        Toast.makeText(MainPage.this, "Tap My Location to send your Location to Police", Toast.LENGTH_LONG).show();

        othrservice = (Button) findViewById(R.id.othse);
        othrservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serv = new Intent(MainPage.this, Menu.class);
                startActivity(serv);

            }
        });

        mainpgsignup = (Button) findViewById(R.id.loginbutt);
        mainpgsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });


        custombutton = (Button) findViewById(R.id.policeactionbutt);
        custombutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                policesiren.start();
                Intent policecall = new Intent(Intent.ACTION_CALL);
                policecall.setData(Uri.parse("tel:08012197791"));
                startActivity(policecall);
                Toast.makeText(MainPage.this, "Calling Police", Toast.LENGTH_SHORT).show();
            }
        });

        Button myLocation = (Button) findViewById(R.id.mylcoationbutt);
        myLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locate = new Intent(MainPage.this, MapLocation.class);
                startActivity(locate);
                Toast.makeText(MainPage.this, "Sending your Location to Get Help", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CODE){
            if((grantResults.length>0)
                    && (grantResults[0] + grantResults[1] + grantResults[2]+ grantResults[3]+ grantResults[4] == PackageManager.PERMISSION_GRANTED)){
                Toast.makeText(getApplicationContext(),"Permissions Granted",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Permissions are Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void permissions(){

        if(ContextCompat.checkSelfPermission(MainPage.this, Manifest.permission.SEND_SMS)+
                ContextCompat.checkSelfPermission(MainPage.this,Manifest.permission.CALL_PHONE)+
                ContextCompat.checkSelfPermission(MainPage.this,Manifest.permission.INTERNET)+
                ContextCompat.checkSelfPermission(MainPage.this,Manifest.permission.ACCESS_COARSE_LOCATION)+
                ContextCompat.checkSelfPermission(MainPage.this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainPage.this,Manifest.permission.SEND_SMS) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(MainPage.this,Manifest.permission.CALL_PHONE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(MainPage.this,Manifest.permission.INTERNET)||
                    ActivityCompat.shouldShowRequestPermissionRationale(MainPage.this,Manifest.permission.ACCESS_FINE_LOCATION)||
                    ActivityCompat.shouldShowRequestPermissionRationale(MainPage.this,Manifest.permission.ACCESS_COARSE_LOCATION)){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
                builder.setTitle("Grant Permissions to have a Better Experience");
                builder.setMessage("To Send SMS,Call,Location");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(
                                MainPage.this,
                                new String[]{
                                        Manifest.permission.SEND_SMS,
                                        Manifest.permission.CALL_PHONE,
                                        Manifest.permission.INTERNET,
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.ACCESS_FINE_LOCATION
                                },
                                REQUEST_CODE
                        );
                    }
                });
                builder.setNegativeButton("Cancel",null);
                AlertDialog al = builder.create();
                al.show();
            }else{
                ActivityCompat.requestPermissions(
                        MainPage.this,
                        new String[]{
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.CALL_PHONE,
                                Manifest.permission.INTERNET,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION
                        },
                        REQUEST_CODE
                );
            }
        }else{
            Toast.makeText(getApplicationContext(),"Permissions Granted Already",Toast.LENGTH_SHORT).show();
        }


    }

}





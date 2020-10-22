package com.sd.kappan;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private LocationManager locationManage;
    private LocationListener locationlistern;

    private final long MINIMUM_TIME=2000;
    private final long MINIMUM_DIST=5;

    private LatLng latlng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActivityCompat.requestPermissions(MapLocation.this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(MapLocation.this,new String[]{Manifest.permission.INTERNET},PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(MapLocation.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},PackageManager.PERMISSION_GRANTED);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        locationlistern = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                try{
                    latlng = new LatLng(location.getLatitude(),location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latlng).title("My Current Location"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));

                    String phoneNumber = "09087911247";
                    String myLatitude = String.valueOf(location.getLatitude());
                    String myLongitude = String.valueOf(location.getLongitude());

                    String message = "Latitude = "+ myLatitude + "Longitude = "+ myLongitude +" " + "Im in Trouble Help Me";
                    SmsManager smsManager = SmsManager.getDefault();
                    SmsManager smsManager1 = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber,null,message,null,null);
                }
                catch(Exception e){
                    e.printStackTrace();

                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        locationManage = (LocationManager) getSystemService(LOCATION_SERVICE);
        try{
            locationManage.requestLocationUpdates(locationManage.NETWORK_PROVIDER,MINIMUM_TIME,MINIMUM_DIST,locationlistern);
            locationManage.requestLocationUpdates(LocationManager.GPS_PROVIDER,MINIMUM_TIME,MINIMUM_DIST,locationlistern);
        }
        catch (SecurityException e){
            e.printStackTrace();

        }


    }
}

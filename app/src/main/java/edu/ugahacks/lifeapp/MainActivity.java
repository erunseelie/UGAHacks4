package edu.ugahacks.lifeapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Error";
    private FusedLocationProviderClient flpc;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    String phone;
    String txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flpc = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        // TODO: implement location access for instant reporting
        if (
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED

                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        }
        Task t = flpc.getLastLocation();



        Button b = findViewById(R.id.call911);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Act_Trauma.class);
                startActivity(i);
            }
        });

    }
    protected void smsText() {
        txtMessage = "This is a Test";
        phone = "(650)-555-1212";

        Intent messageIntent = new Intent(Intent.ACTION_SENDTO);
        messageIntent.setData(Uri.parse(phone));
        messageIntent.putExtra("Message", txtMessage);
        Log.i("Output is : ", txtMessage);
        if(messageIntent.resolveActivity(getPackageManager()) != null){
            startActivity(messageIntent);
            Log.i("Is there a message?  ", txtMessage);
        }else{
            Log.d(TAG,"No message");
        }

    }



}

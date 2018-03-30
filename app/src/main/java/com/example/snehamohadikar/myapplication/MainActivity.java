package com.example.snehamohadikar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TableLayout;

import java.net.URI;
import java.net.URL;
import java.io.File;

import android.location.*;
import android.os.Environment;

import java.io.OutputStream;
import java.io.*;
import java.io.InputStream;

import android.widget.Toast;
import android.net.Uri;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;

import java.util.Random;

import android.location.*;

import com.google.android.gms.location.*;
import com.google.android.gms.location.LocationListener;

public class MainActivity extends AppCompatActivity {

    private Button btnCamera1;
    private Button btnCamera2;
    private ImageView capturedImage;
    GPS gp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera1 = findViewById(R.id.btnCamera);
        capturedImage = findViewById(R.id.capturedImage);
        btnCamera2 = findViewById(R.id.button2);
        btnCamera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        btnCamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gp = new GPS(MainActivity.this);

                // check if GPS enabled
                if (gp.canGetLocation()) {

                    double latitude = gp.getLatitude();
                    double longitude = gp.getLongitude();

                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                } else {
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gp.showSettingsAlert();
                }

            }
        });
    }





    private void openCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    // Acquire a reference to the system Location Manager


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            capturedImage.setImageBitmap(bp);


        }
    }


}

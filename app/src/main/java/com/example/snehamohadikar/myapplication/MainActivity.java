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

import android.os.Environment;

import java.io.OutputStream;
import java.io.*;

import android.widget.Toast;
import android.net.Uri;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button btnCamera1;
    private ImageView capturedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera1 = findViewById(R.id.btnCamera);
        capturedImage = findViewById(R.id.capturedImage);
        btnCamera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }


   /* public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/


  /*  public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    private void openCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    boolean storeImage(Bitmap bp, String filename) {
        //get path to external storage (SD card)
        File sdIconStorageDir = new File(getExternalFilesDir(null), filename);

        //create storage directories, if they don't exist
        sdIconStorageDir.mkdirs();

        try {
           /* String filePath = sdIconStorageDir.toString() + filename;
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);

            //choose another format if PNG doesn't suit you
            bp.compress(CompressFormat.PNG, 100, bos);

            bos.flush();
            bos.close();
            /

           InputStream is=bp;
           OutputStream os=new FileOutputStream(sdIconStorageDir);
           byte[] data= new byte[is.available()];
           is.read(data);
           os.write(data);
           is.close();
           os.close();
        } catch (FileNotFoundException e) {
            Log.w("TAG", "Error saving image file: " + e.getMessage());
            return false;
        } catch (IOException e) {
            Log.w("TAG", "Error saving image file: " + e.getMessage());
            return false;
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            capturedImage.setImageBitmap(bp);

            storeImage(bp,"kanchu");
        }
    }


}

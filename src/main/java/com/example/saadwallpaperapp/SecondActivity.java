package com.example.saadwallpaperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.btn);
        imageView = findViewById(R.id.img);

        int get_wallpaper = getIntent().getIntExtra("w_key",0);
        imageView.setImageResource(get_wallpaper);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),get_wallpaper);
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                try {
                    wallpaperManager.setBitmap(bitmap);

                    Toast.makeText(getApplicationContext(),"WALLPAPER CHANGED SUCCESSFULLY", Toast.LENGTH_SHORT).show();


                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"WALLPAPER FAILED TO UPLOAD", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

    }
}
package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.farming.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView weatherImg = findViewById(R.id.weatherImg);
        weatherImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //weather Activity
                Intent weatherIntent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(weatherIntent);
            }
        });

        ImageView newsImg = findViewById(R.id.newsImg);
        newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //news Activity
                Intent newsIntent = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(newsIntent);
            }
        });

        ImageView contactImg = findViewById(R.id.contactImg);
        contactImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //contact Activity
                Intent newsIntent = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(newsIntent);
            }
        });

    }
}
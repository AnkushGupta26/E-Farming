package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        ImageView newsImg = findViewById(R.id.productimg);
        newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //news Activity
                Intent newsIntent = new Intent(MainActivity.this, NewsActivity.class);
                newsIntent.putExtra("url", "https://krishijagran.com/agriculture-world");
                startActivity(newsIntent);
            }
        });

        ImageView harvestImg = findViewById(R.id.harvestImgView);
        harvestImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // harvest Activity
                Intent harvestIntent = new Intent(MainActivity.this, HarvestActivity.class);
                startActivity(harvestIntent);
            }
        });

        ImageView productImg = findViewById(R.id.productImgView);
        productImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //product Activity
                Intent productIntent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(productIntent);
            }
        });

        ImageView contactImg = findViewById(R.id.contactImg);
        contactImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //contact Activity
                Intent contactIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contactIntent);
            }
        });
    }
}
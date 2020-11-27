package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HarvestActivity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.wheat, R.drawable.rice, R.drawable.gram, R.drawable.cotton, R.drawable.sunflower,
            R.drawable.rajma, R.drawable.mango, R.drawable.potato, R.drawable.onion, R.drawable.apple};
    String[] CROPS = {"Wheat", "Rice", "Gram", "Cotton", "Sunflower", "Rajma", "Mango", "Potato", "Onion", "Apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);
        ListView harvestListView = findViewById(R.id.harvestListView);
        HarvestAdapter harvestAdapter = new HarvestAdapter();
        harvestListView.setAdapter(harvestAdapter);
        harvestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent harvestViewIntent = new Intent(HarvestActivity.this, HarvestViewActivity.class);
                harvestViewIntent.putExtra("position", position);
                startActivity(harvestViewIntent);
            }
        });
    }

    class HarvestAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.harvest_item, null);
            ImageView imageView = view.findViewById(R.id.harvestImg);
            TextView harvestText = view.findViewById(R.id.harvestName);
            imageView.setImageResource(IMAGES[position]);
            harvestText.setText(CROPS[position]);
            return view;
        }
    }

}
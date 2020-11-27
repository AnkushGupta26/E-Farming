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

public class ProductActivity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.mini_tiller, R.drawable.garden_sprayer, R.drawable.agriculture_saw, R.drawable.hand_tractor, R.drawable.garden_spade, R.drawable.mannual_wheel, R.drawable.grass_cutter};
    String[] EQUIPMENT = {"Mini Tiller", "Garden Sprayer", "Agriculture Saw", "Hand Tracktor", "Garden Spade", "Manual Wheel Hoe", "Grass Cutter"};
    String[] PRICE = {"₹10,600", "₹1,299", "₹4,448", "₹4,450", "₹770", "₹3,370", "₹15,000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ListView harvestListView = findViewById(R.id.productListView);
        HarvestAdapter harvestAdapter = new HarvestAdapter();
        harvestListView.setAdapter(harvestAdapter);
        harvestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent productViewIntent = new Intent(ProductActivity.this, ProductViewActivity.class);
                productViewIntent.putExtra("position", position);
                startActivity(productViewIntent);
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
            view = getLayoutInflater().inflate(R.layout.product_item, null);
            ImageView imageView = view.findViewById(R.id.productImg);
            TextView productText = view.findViewById(R.id.productName);
            TextView productPriceText = view.findViewById(R.id.productPrice);
            imageView.setImageResource(IMAGES[position]);
            productText.setText(EQUIPMENT[position]);
            productPriceText.setText(PRICE[position]);
            return view;
        }
    }

}
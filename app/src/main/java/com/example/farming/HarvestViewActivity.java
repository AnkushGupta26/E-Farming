package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class HarvestViewActivity extends AppCompatActivity {
    WebView harvestWebView;
    String[] harvestUrl = {"https://krishijagran.com/agripedia/how-to-grow-wheat/",
            "https://www.hgtv.com/outdoors/landscaping-and-hardscaping/how-to-grow-rice",
            "https://krishijagran.com/agripedia/how-to-grow-chickpea/",
            "https://dainikjagrati.com/%E0%A4%95%E0%A4%AA%E0%A4%BE%E0%A4%B8-%E0%A4%95%E0%A5%80-%E0%A4%96%E0%A5%87%E0%A4%A4%E0%A5%80-%E0%A4%95%E0%A5%88%E0%A4%B8%E0%A5%87-%E0%A4%95%E0%A4%B0%E0%A5%87%E0%A4%82-how-to-cultivate-cotton-in-hind/",
            "https://www.alkarty.com/how-to-grow-sunflower-seeds-summer-in-hindi.html#:~:text=%E0%A4%B8%E0%A4%AC%E0%A4%B8%E0%A5%87%20%E0%A4%AA%E0%A4%B9%E0%A4%B2%E0%A5%87%20%E0%A4%A8%E0%A5%80%E0%A4%9A%E0%A5%87%20%E0%A4%95%E0%A5%80%20%E0%A4%A4%E0%A4%B0%E0%A4%AB,%E0%A4%AA%E0%A5%82%E0%A4%B0%E0%A5%80%20%E0%A4%A4%E0%A4%B0%E0%A4%B9%20%E0%A4%B8%E0%A5%87%20%E0%A4%A2%E0%A4%95%20%E0%A4%A6%E0%A5%87%E0%A4%82%E0%A5%A4",
            "https://www.apnikheti.com/en/pn/agriculture/crops/pulses/kidney-bean-rajma",
            "https://m-hindi.indiawaterportal.org/content?slug=ama-kai-unanata-baagavaanai-kaaisae-karaen&type=content-type-page&id=63539&amp=1",
            "https://dainikjagrati.com/%E0%A4%86%E0%A4%B2%E0%A5%82-%E0%A4%95%E0%A5%80-%E0%A4%96%E0%A5%87%E0%A4%A4%E0%A5%80-potato-cultivation-hindi/",
            "https://dainikjagrati.com/%E0%A4%AA%E0%A5%8D%E0%A4%AF%E0%A4%BE%E0%A4%9C-%E0%A4%95%E0%A5%80-%E0%A4%96%E0%A5%87%E0%A4%A4%E0%A5%80-farming-of-onion-in-hindi/",
            "https://www.almanac.com/plant/apples"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_view);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String url = harvestUrl[position];
        harvestWebView = (WebView) findViewById(R.id.harvestWebView);
        harvestWebView.setWebChromeClient(new WebChromeClient());
        harvestWebView.loadUrl(url);
    }
}
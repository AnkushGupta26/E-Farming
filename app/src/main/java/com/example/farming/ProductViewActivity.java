package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class ProductViewActivity extends AppCompatActivity {
    WebView productWebView;
    String[] productUrl = {"https://www.toolsvilla.com/petrol-mini-cultivator-imported.html?gclid=CjwKCAiA5IL-BRAzEiwA0lcWYkwa0mJ7RmLvrjj2Vyc0MzUZUzrVA3tSlvWUDyaK3_V3RjOlSE7_uBoCwyEQAvD_BwE",
                        "https://www.amazon.in/Pressure-Sprayer-Ltr-Srisai-Naturals/dp/B01JDDYL5O/ref=pd_aw_sbs_86_3/261-9113928-9428851?_encoding=UTF8&pd_rd_i=B01JDDYL5O&pd_rd_r=10c82af0-7dbc-48db-9f20-674068ab88ee&pd_rd_w=lXzKB&pd_rd_wg=O6mVc&pf_rd_p=0d69d15e-4c82-413b-ac5e-75d3769e25f9&pf_rd_r=WYW1D69QTT829XZCRA4W&psc=1&refRID=WYW1D69QTT829XZCRA4W",
                        "https://www.sampoorti.in/shop/farm-equipment/chainsaws/agriculture-saw-62/",
                        "https://www.toolsvilla.com/hand-tractor-with-seeder-attachment.html",
                        "https://www.amazon.in/Pretail-Garden-Wooden-Handle-Agricultural/dp/B07JQD81KF",
                        "https://www.amazon.in/Hectare-Weeder-Cultivator-Furrow-Attachment/dp/B07V2CZWNX/ref=mp_s_a_1_12?dchild=1&keywords=hand+hoes&qid=1606492171&sr=8-12",
                        "https://www.amazon.in/GREAVES-GS-CG-530-COTTON/dp/B0176ESCOS/ref=asc_df_B0176ESCOS/?tag=googleshopmob-21&linkCode=df0&hvadid=397032057330&hvpos=&hvnetw=g&hvrand=7471095882927899272&hvpone=&hvptwo=&hvqmt=&hvdev=m&hvdvcmdl=&hvlocint=&hvlocphy=9301185&hvtargid=pla-405643160281&psc=1&ext_vrnc=hi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String url = productUrl[position];
        productWebView = (WebView) findViewById(R.id.productWebView);
        productWebView.setWebChromeClient(new WebChromeClient());
        productWebView.loadUrl(url);
    }
}
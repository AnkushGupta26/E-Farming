package com.example.farming.weather;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.farming.R;
import com.example.farming.WeatherDetail;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    RequestQueue rq;
    TextView nameText,tempText, mainText, windText, cloudText, pressureText,
            humidityText, minTempText, maxTempText, visibilityText;
    String location = "mumbai ";
    String main, cloud, name, iconUrl;
    int temp, pressure, humidity, maxTemp, minTemp, wind, visibility;
    ImageView iconView, sendView;
    SearchView searchView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        rq = Volley.newRequestQueue(this);
        visibilityText = findViewById(R.id.visibilityTextView);
        nameText = findViewById(R.id.nameTextView);
        tempText = findViewById(R.id.tempTextView);
        mainText = findViewById(R.id.mainTextView);
        windText = findViewById(R.id.windTextView);
        cloudText = findViewById(R.id.cloudTextView);
        pressureText = findViewById(R.id.pressureTextView);
        humidityText = findViewById(R.id.humidtyTextView);
        minTempText = findViewById(R.id.minTempTextView);
        maxTempText = findViewById(R.id.maxTempTextView);
        iconView = findViewById(R.id.weatherIcon);
        searchView = findViewById(R.id.searchView);
        sendView = findViewById(R.id.sendView);
        weatherDetail();

        sendView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                location = searchView.getQuery().toString();
                weatherDetail();
                hideSoftKeyboard(WeatherActivity.this);
                searchView.setQuery("", false);
            }
        });

    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void weatherDetail(){
        url = "https://api.openweathermap.org/data/2.5/weather?q=" + location +"&appid=ef07a3da758a5f7d59437c2c23f79743";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray weatherArray = new JSONArray(jsonObject.getString("weather"));
                    JSONObject weatherObj = new JSONObject(weatherArray.getString(0));
                    JSONObject mainObj = new JSONObject(jsonObject.getString("main"));
                    JSONObject windObj = new JSONObject(jsonObject.getString("wind"));
                    Log.d("location", "location is " + mainObj.getDouble("temp"));
                    visibility = (int) (jsonObject.getDouble("visibility")/1000);
                    visibilityText.setText("Visibility : " + String.valueOf(visibility) + "km");
                    temp = (int)(mainObj.getDouble("temp")-273.15);
                    tempText.setText(String.valueOf(temp + "°C"));
                    humidity = (int)mainObj.getDouble("humidity");
                    humidityText.setText("Humidity : " + String.valueOf(humidity + "%"));
                    pressure = (int)mainObj.getDouble("pressure");
                    pressureText.setText("Pressure : " + String.valueOf(pressure + "hPa"));
                    wind = (int)(windObj.getDouble("speed")*3.6);
                    windText.setText("Wind: " + String.valueOf(wind + "km/h"));
                    cloud = weatherObj.getString("description");
                    cloudText.setText("Cloud : " + cloud);
                    name = jsonObject.getString("name");
                    nameText.setText(name);
                    main = weatherObj.getString("main");
                    mainText.setText(main);
                    minTemp = (int)(mainObj.getDouble("temp_min")-273.15);
                    minTempText.setText("Min Temp : " + String.valueOf(minTemp + "°C"));
                    maxTemp = (int)(mainObj.getDouble("temp_max")-273.15);
                    maxTempText.setText("Max Temp :" + String.valueOf(maxTemp + "°C"));
                    iconUrl = "https://openweathermap.org/img/w/" + weatherObj.getString("icon") + ".png";
                    Picasso.get().load(iconUrl).into(iconView);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("location", "Something went wrong");
            }
        });
        rq.add(jsonObjectRequest);


    }



}
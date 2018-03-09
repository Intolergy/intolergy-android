package com.intolergy.intolergy;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        ImageView foodIcon=(ImageView)findViewById(R.id.foodIcon);
        ImageView homeIcon=(ImageView)findViewById(R.id.homeIcon);
        ImageView restaurantIcon = (ImageView)findViewById(R.id.restaurantIcon);
        foodIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                System.out.println("FoodIcon");
            }
        });
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                System.out.println("HomeIcon");
            }
        });
        restaurantIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                System.out.println("RestaurantIcon");
            }
        });
    }

}

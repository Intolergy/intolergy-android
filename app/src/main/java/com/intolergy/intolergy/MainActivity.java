package com.intolergy.intolergy;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
                Log.d("main","entra");
                startActivity(new Intent(v.getContext(), Category.class));
            }
        });
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("main","entra");
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
        restaurantIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(v.getContext(), Find_Restaurant.class));
            }
        });
    }

}

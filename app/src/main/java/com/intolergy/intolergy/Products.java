package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ImageView foodIcon=(ImageView)findViewById(R.id.foodIcon1);
        ImageView homeIcon=(ImageView)findViewById(R.id.homeIcon1);
        ImageView restaurantIcon = (ImageView)findViewById(R.id.restaurantIcon1);
        foodIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("main","entra");
                startActivity(new Intent(v.getContext(), Find_Product.class));
            }
        });
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("main","entra");
                startActivity(new Intent(v.getContext(), Category.class));
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

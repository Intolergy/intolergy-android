package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageView foodIcon=(ImageView)findViewById(R.id.foodIcon2);
        ImageView homeIcon=(ImageView)findViewById(R.id.homeIcon2);
        ImageView restaurantIcon = (ImageView)findViewById(R.id.restaurantIcon2);
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
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
        restaurantIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(v.getContext(), Find_Restaurant.class));
            }
        });

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        gridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("main","entra");
                startActivity(new Intent(v.getContext(), Find_Product.class));
            }
        });

    }
    public void newProduct(View v) {
        Intent intent = new Intent(this, AddProduct.class);
        startActivity(intent);
    }
    public void searchProduct(View v) {

    }
}


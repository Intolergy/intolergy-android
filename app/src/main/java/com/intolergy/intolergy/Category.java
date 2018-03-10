package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        GridLayout grid = (GridLayout) findViewById(R.id.GridLayout);
        int count = grid.getChildCount();
        for (int i = 0; i < count; i++) {
            RelativeLayout container = (RelativeLayout) grid.getChildAt(i);
            container.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    startActivity(new Intent(view.getContext(), FindProduct.class));
                }
            });
        }
    }
}


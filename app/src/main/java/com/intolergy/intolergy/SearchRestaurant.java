package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class SearchRestaurant extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurant);

        ImageView foodIcon=(ImageView)findViewById(R.id.foodIcon3);
        ImageView homeIcon=(ImageView)findViewById(R.id.homeIcon3);
        ImageView restaurantIcon = (ImageView)findViewById(R.id.restaurantIcon3);
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


        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Mesón Aguia",
                "Pizza Plus",
                "Amodo Restaurante Orgánico",
                "Zona Cero",
                "Pizzería Napolitana",
                "Detapaencepa",
                "Restaurante Bitadorna",
                "Tapería Madia Leva"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition= position;

                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
    }

}
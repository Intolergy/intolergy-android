package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Find_Product extends AppCompatActivity {
    private static boolean preferences=false;
    private static boolean intolerances=false;
    private static boolean zone=false;
    private static boolean egg=false;
    private static boolean lactose=false;
    private static boolean fructose=false;
    private static boolean gluten=false;
    private static boolean yeast=false;
    private static boolean shellfish=false;
    private static boolean nuts=false;
    private static boolean pulse=false;
    private Button find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        ImageView foodIcon=(ImageView)findViewById(R.id.foodIcon4);
        ImageView homeIcon=(ImageView)findViewById(R.id.homeIcon4);
        ImageView restaurantIcon = (ImageView)findViewById(R.id.restaurantIcon4);
        foodIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("main","entra");
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
        find = (Button)findViewById(R.id.button2);

        find.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                 startActivity(new Intent(view.getContext(), Products.class));
                //Enviar aquí en función a las variables true y false arriba
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_preferences:
                if (checked){
                    preferences=true;
                    intolerances=false;
                    zone=false;
                }
                break;
            case R.id.radio_intolerances:
                if (checked){
                    preferences=false;
                    intolerances=true;
                    zone=false;
                }
                break;

        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox_Egg:
                if (checked)
                    egg=true;
                else
                    egg=false;
                break;
            case R.id.checkBox_Fructose:
                if (checked)
                    fructose=true;
                else
                    fructose=false;
                break;
            case R.id.checkBox_gluten:
                if (checked)
                    gluten=true;
                else
                    gluten=false;
                break;
            case R.id.checkBox_Lactose:
                if (checked)
                    lactose=true;
                else
                    lactose=false;
                break;
            case R.id.checkBox_Nuts:
                if (checked)
                    nuts=true;
                else
                    nuts=false;
                break;
            case R.id.checkBox_Pulse:
                if (checked)
                    pulse=true;
                else
                    pulse=false;
                break;
            case R.id.checkBox_Shellfish:
                if (checked)
                    shellfish=true;
                else
                    shellfish=false;
                break;
            case R.id.checkBox_Yeast:
                if (checked)
                    yeast=true;
                else
                    yeast=false;
                break;
        }
    }


}

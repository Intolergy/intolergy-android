package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddProduct extends AppCompatActivity {

    private static String nombre;
    private static String description;
    private static String barcode;
    private static String URL;
    private Button btnLogin;
    private EditText named,barcoded,descripted,urled;

    private static boolean egg=false;
    private static boolean lactose=false;
    private static boolean fructose=false;
    private static boolean gluten=false;
    private static boolean yeast=false;
    private static boolean shellfish=false;
    private static boolean nuts=false;
    private static boolean pulse=false;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        btnLogin = (Button)findViewById(R.id.button);
        named = (EditText) findViewById(R.id.name);
        barcoded = (EditText) findViewById(R.id.barcode);
        descripted = (EditText) findViewById(R.id.descript);
        urled = (EditText) findViewById(R.id.Url);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String name2 = named.getText().toString();
                String barcode2 = barcoded.getText().toString();
                String descripted2 = descripted.getText().toString();
                String urled2 =urled.getText().toString();
                startActivity(new Intent(view.getContext(), MainActivity.class));
                //Enviar aquí en función a las variables true y false arriba
            }
        });


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

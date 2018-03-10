package com.intolergy.intolergy;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Register extends AppCompatActivity {

    Button signin = null;
    boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_register);
        signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    register();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void checkAlergy(View view) {
        // Is the view now checked?
        checked = ((CheckBox) view).isChecked();
        Log.d("register", checked + " " + view.getId());

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.gluten:
                Log.d("register", "GLUTEN");
                if (checked) {

                }
                break;
            case R.id.nuts:
                if (checked) {

                }
            case R.id.lactose:
                if (checked) {

                }
                break;
            case R.id.egg:
                if (checked) {

                }
            case R.id.yeast:
                if (checked) {

                }
                break;
            case R.id.pulse:
                if (checked) {

                }
                break;
            case R.id.fructose:
                if (checked) {

                }
                break;
            case R.id.shellfish:
                if (checked) {

                }
                // TODO: Veggie sandwich
        }
    }

    private void register() throws JSONException, IOException {

        EditText username = (EditText) findViewById(R.id.userInput);
        EditText password = (EditText) findViewById(R.id.passInput);
        EditText email = (EditText) findViewById(R.id.email);
        EditText name = (EditText) findViewById(R.id.name);
        EditText postalCode = (EditText) findViewById(R.id.postalcode);
        JSONObject json = new JSONObject();
        json.put("name", username.getText());
        json.put("password", password.getText());
        json.put("intolerances", "gluten, lactosa");
        if(!ApiClient.signup(json).getBoolean("error")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}

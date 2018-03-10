package com.intolergy.intolergy;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Login extends AppCompatActivity {

    private Button button= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        button = (Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    login();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void forgot(View v) {
        Log.d("login","contraseña olvidada");

    }

    public void register(View v) {
        Log.d("login","contraseña olvidada");
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void login() throws JSONException, IOException {

        EditText username = (EditText)findViewById(R.id.user);
        EditText password = (EditText)findViewById(R.id.pass);
        JSONObject json = new JSONObject();
        json.put("name", username.getText());
        json.put("password", password.getText());
        System.out.println(ApiClient.login(json));
        if(!ApiClient.login(json).getBoolean("error")){
            startActivity(new Intent(this,MainActivity.class));
        }
    }

}

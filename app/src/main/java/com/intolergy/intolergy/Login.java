package com.intolergy.intolergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private Button button= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        button = (Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
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

    private void login(){

        EditText username = (EditText)findViewById(R.id.user);
        EditText password = (EditText)findViewById(R.id.pass);

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Log.d("login","correcto");
            //correcct password
            startActivity(new Intent(this, MainActivity.class));
        }else{
            Log.d("login","incorrecto");
            //wrong password
        }

    }

}

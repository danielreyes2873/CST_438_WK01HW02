package com.example.cst_438_wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etName);
        password = (EditText)findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.btnLogin);

        login.setOnClickListener(this);
    }

    public void onClick(View v) {
        validate(username.getText().toString(),password.getText().toString());
    }

    private void validate(String userN, String userP) {
        if ((userN.equalsIgnoreCase("Admin")) && (userP.equals("Admin"))) {
            startActivity(new Intent(this, MainActivity2.class));
        } else {
            Toast.makeText(this, "Login Error",Toast.LENGTH_SHORT).show();
        }
    }
}
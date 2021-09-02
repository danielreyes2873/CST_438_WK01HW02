package com.example.cst_438_wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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

    private List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etName);
        password = (EditText)findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.btnLogin);

        login.setOnClickListener(this);

        users.add(new User());
        users.add(new User(2,"alice","@licE"));
        users.add(new User(3,"bob","B0b"));
        users.add(new User(4,"chris","Chr1$"));
    }

    public void onClick(View v) {
        String userN = username.getText().toString();
        String userP = password.getText().toString();
        boolean found = false;
        for(int i = 0; i < users.size(); i++) {
            if(userN.equalsIgnoreCase(users.get(i).getUsername())) {
                validate(users.get(i),userP);
                found = true;
            }
        }
        if(!found) {
            Toast.makeText(this,"Username not found",Toast.LENGTH_SHORT).show();
        }
    }

    private void validate(User user, String userP) {
        if (userP.equals(user.getPassword())) {
            Intent i = new Intent(this, MainActivity2.class);
            Bundle c = new Bundle();
            c.putString("username",user.getUsername());
            c.putInt("userId",user.getUserId());
            i.putExtras(c);
            startActivity(i);
        } else {
            Toast.makeText(this, "Password Incorrect",Toast.LENGTH_SHORT).show();
        }
    }
}
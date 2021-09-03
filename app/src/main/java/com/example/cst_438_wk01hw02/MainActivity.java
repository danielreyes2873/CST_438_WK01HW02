package com.example.cst_438_wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    private static TextView error;
    private Button login;
    private static Context mContext;

    private static List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etName);
        password = (EditText)findViewById(R.id.etPassword);
        error = (TextView)findViewById(R.id.tvError);
        login = (Button)findViewById(R.id.btnLogin);
        mContext = this;

        populate();
        login.setOnClickListener(this);

    }

    public void onClick(View v) {
        String userN = username.getText().toString();
        String userP = password.getText().toString();
        validateUsername(userN,userP);
    }

    public static boolean validateUsername(String userN, String userP) {
        boolean found = false;
        for(int i = 0; i < users.size(); i++) {
            if(userN.equalsIgnoreCase(users.get(i).getUsername())) {
                //username.setBackgroundColor(getResources().getColor(android.R.color.white));
                //password.setBackgroundColor(getResources().getColor(android.R.color.white));
                if(error != null) {
                    error.setText("");
                }
                found = true;
                validatePassword(users.get(i),userP);
            }
        }
        if(!found) {
            if(error != null) {
                error.setText("Username not found");
            }
            //username.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
            //password.setBackgroundColor(getResources().getColor(android.R.color.white));
        }
        return found;
    }

    public static boolean validatePassword(User user, String userP) {
        if (userP.equals(user.getPassword())) {
            if(error != null) {
                error.setText("");
            }
            if(mContext != null) {
                mContext.startActivity(intentFactory(mContext, user));
            }
            return true;
        } else {
            //password.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
            if(error != null) {
                error.setText("Password Incorrect");
            }
            return false;
        }
    }

    public static Intent intentFactory(Context context, User user) {
        Intent i = new Intent(context, MainActivity2.class);
        Bundle c = new Bundle();
        c.putString("username",user.getUsername());
        c.putInt("userId",user.getUserId());
        i.putExtras(c);
        return i;
    }

    public static void populate() {
        users.add(new User());
        users.add(new User(2,"alice","@licE"));
        users.add(new User(3,"bob","B0b"));
        users.add(new User(4,"chris","Chr1$"));
        users.add(new User(5,"Daniel","asdf1234"));
    }
}
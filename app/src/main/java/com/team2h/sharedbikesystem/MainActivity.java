package com.team2h.sharedbikesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.team2h.sharedbikesystem.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignIn(View view) {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String username_str = username.getText().toString();
        String password_str = password.getText().toString();
        User user = new User(username_str,password_str);
        if(user.SignIn(MainActivity.this)){
            Intent intent = new Intent(this, MainMapActivity.class);
            intent.putExtra(EXTRA_MESSAGE, username_str);
            startActivity(intent);
        } else {
            TextView signin_msg = findViewById(R.id.signin_msg);
            signin_msg.setText("Sign in Failed");
        }
    }

    public void ToSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        EditText username = findViewById(R.id.username);
        String username_pass = username.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, username_pass);
        startActivity(intent);
    }

}

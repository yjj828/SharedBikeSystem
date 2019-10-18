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

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Intent intent = getIntent();
        EditText username = findViewById(R.id.username_up);
        username.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
    }

    public void SignUp(View view) {
        EditText username = findViewById(R.id.username_up);
        EditText password = findViewById(R.id.password_up);
        EditText phoneNumber = findViewById(R.id.phone_up);
        EditText address = findViewById(R.id.address_up);
        String username_text = username.getText().toString();
        String password_text = password.getText().toString();
        String phoneNumber_text = phoneNumber.getText().toString();
        String address_text = address.getText().toString();
        System.out.println("address: " + address_text);
        DBHelper dbHelper = new DBHelper(SignUpActivity.this,"SBSDB",null,2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user", new String[]{});
        ContentValues values = new ContentValues();
        values.put("id",cursor.getCount() + 1);
        values.put("username",username_text);
        values.put("password",password_text);
        values.put("phonenumber",phoneNumber_text);
        values.put("address",address_text);
        values.put("balance",0);
        Cursor c = db.rawQuery("select * from user where username=?",new String[]{username_text});
        if(c.getCount()>0){
            TextView signup_msg = findViewById(R.id.signup_msg);
            signup_msg.setText("Sign Up Failed");
        } else if(username_text == " " || password_text == " " || phoneNumber_text == " " || address_text == " ") {
            TextView signup_msg = findViewById(R.id.signup_msg);
            signup_msg.setText("Sign Up Failed");
        } else {
            db.insert("user", null, values);
            Intent intent = new Intent(this, MainMapActivity.class);
            intent.putExtra(MainActivity.EXTRA_MESSAGE, username_text);
            startActivity(intent);
        }
    }
}

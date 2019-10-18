package com.team2h.sharedbikesystem;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class User {
    private String username;
    private String password;

    public User(String username_str, String password_str) {
        this.username = username_str;
        this.password = password_str;
    }

    public float GetBalance(Context context){
        DBHelper dbHelper = new DBHelper(context, "SBSDB", null, 2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user where username=?",new String[]{username});
        float balance = -1;
        if(c.moveToFirst()) {
            balance = Float.parseFloat(c.getString(c.getColumnIndex("balance")));
        }
        return balance;
    }

    public boolean SignIn(Context context) {
        DBHelper dbHelper = new DBHelper(context, "SBSDB", null, 2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        if(c.getCount()>0){
            return true;
        } else {
            return false;
        }
    }

}

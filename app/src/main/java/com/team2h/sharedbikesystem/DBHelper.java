package com.team2h.sharedbikesystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String crt_user = "create table user(id integer primary key, username varchar(16), password varchar(16) not null, phonenumber varchar(20) not null, address varchar(64) not null, balance numeric)";
        sqLiteDatabase.execSQL(crt_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }
}

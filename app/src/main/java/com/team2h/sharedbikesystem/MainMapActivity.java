package com.team2h.sharedbikesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }
}

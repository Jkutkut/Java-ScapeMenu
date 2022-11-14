package com.jkutkut.scapemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class EndActivity extends AppCompatActivity {

    private Button btnIntent;
    private Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        btnIntent = findViewById(R.id.btnIntent);
        btnEnd = findViewById(R.id.btnEnd);

        btnIntent.setOnClickListener(v -> {
            // Open website
            // TODO not working on android 11, API 30
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getString(R.string.web)));
            if (i.resolveActivity(getPackageManager()) != null)
                startActivity(i);
        });

        btnEnd.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        });
    }
}
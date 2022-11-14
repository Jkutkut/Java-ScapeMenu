package com.jkutkut.scapemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class KeygenActivity extends AppCompatActivity {

    private Button btnWithKey;
    private Button btnWithoutKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keygen);

        btnWithKey = findViewById(R.id.btnWithKey);
        btnWithoutKey = findViewById(R.id.btnWithoutKey);

        btnWithKey.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        btnWithoutKey.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
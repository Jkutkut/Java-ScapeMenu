package com.jkutkut.scapemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DivideActivity1 extends AppCompatActivity {

    private String user;

    private TextView txtvMsg;
    private Button btnGoodPath;
    private Button btnBadPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divide1);

        user = getIntent().getStringExtra("user");
        txtvMsg = findViewById(R.id.txtvMsg);
        btnGoodPath = findViewById(R.id.btnGoodPath);
        btnBadPath = findViewById(R.id.btnBadPath);

        // Init
        txtvMsg.setText(String.format(
            getString(R.string.divide1_msg),
            user
        ));

        // Click listeners
        btnGoodPath.setOnClickListener(v -> {
           Intent i = new Intent(this, DivideActivity2.class);
           i.putExtra("user", user);
           startActivity(i);
        });

        btnBadPath.setOnClickListener(v -> {
            Intent i = new Intent(this, CallActivity.class);
            startActivity(i);
        });
    }
}
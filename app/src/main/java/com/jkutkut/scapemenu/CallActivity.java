package com.jkutkut.scapemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class CallActivity extends AppCompatActivity {

    private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(v -> {
            Intent i = new Intent(
                    Intent.ACTION_DIAL,
                    // Better than ACTION_CALL.
                    // It doesn't make the call, just opens the dialer.
                    // Doesn't require permission.
                    Uri.parse("tel:" + getInt(R.integer.phone_number))
            );
            startActivity(i);
        });
    }

    private int getInt(int id) {
        return getResources().getInteger(id);
    }
}
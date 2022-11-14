package com.jkutkut.scapemenu;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DivideActivity2 extends AppCompatActivity {

    // ***** CONSTANTS *****
    private String user;
    private boolean hasKey;

    // ***** UI ELEMENTS *****
    private TextView txtvMsg;
    private Button btnOpen;
    private Button btnKeyGen;

    // ***** ACTIVITY LIFECYCLE *****
    private ActivityResultLauncher<Intent> startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divide2);

        hasKey = false;
        user = getIntent().getStringExtra("user");
        txtvMsg = findViewById(R.id.txtvMsg);
        btnOpen = findViewById(R.id.btnOpen);
        btnKeyGen = findViewById(R.id.btnKeyGen);

        // Init
        txtvMsg.setText(String.format(
            getString(R.string.divide2_msg),
            user
        ));

        btnOpen.setOnClickListener(v -> handleBtnOpen());
        btnKeyGen.setOnClickListener(v -> handleBtnKeyGen());

        // ActivityResultLauncher
        startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    hasKey = true;
                    toastUser(getString(R.string.divide2_back_with_key));
                }
                else
                    toastUser(getString(R.string.divide2_back_no_key));
            }
        );
    }

    private void handleBtnOpen() {
        if (!hasKey) {
            toastUser(getString(R.string.divide2_error));
            return;
        }
        launchEnd();
    }

    private void handleBtnKeyGen() {
        Intent i = new Intent(this, KeygenActivity.class);
        startActivityForResult.launch(i);
    }

    private void launchEnd() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
    }

    // TOOLS
    private void toastUser(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
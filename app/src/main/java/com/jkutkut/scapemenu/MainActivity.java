package com.jkutkut.scapemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ********* UI Elements *********
    private EditText etxtUser;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ********* UI Elements *********
        etxtUser = findViewById(R.id.etxtUser);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(l -> login());
    }

    private void login() {
        String user = etxtUser.getText().toString().trim();
        if (user.length() < getInt(R.integer.login_min_length) || user.length() > getInt(R.integer.login_max_length)) {
            toastUser(
                String.format(
                    getString(R.string.login_error_length),
                    getInt(R.integer.login_min_length),
                    getInt(R.integer.login_max_length)
                )
            );
            return;
        }
        openDivideActivity1(user);
    }

    private void openDivideActivity1(String user) {
        Intent i = new Intent(this, DivideActivity1.class);
        i.putExtra(getString(R.string.user), user);
        startActivity(i);
    }

    // TOOLS

    private int getInt(int id) {
        return getResources().getInteger(id);
    }

    private void toastUser(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
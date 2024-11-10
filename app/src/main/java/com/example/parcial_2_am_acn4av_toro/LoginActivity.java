package com.example.parcial_2_am_acn4av_toro;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick(View view){
        EditText emailField = findViewById(R.id.login_email);
        EditText passwordField = findViewById(R.id.login_password);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        Log.i("firebase mandoca", email);
        Log.i("firebase mandoca", password);
    }

}

package com.maus.hash_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sesion extends AppCompatActivity {

    TextView email, passwordHash, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        email = findViewById(R.id.Email_show);
        passwordHash = findViewById(R.id.PasswordHas);
        password = findViewById(R.id.PasswordN);

        Bundle extras = getIntent().getExtras();
        email.setText(extras.getString("1"));
        passwordHash.setText(extras.getString("2"));
        password.setText(extras.getString("3"));
    }
    public void Atras(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
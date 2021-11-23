package com.maus.hash_login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity2 extends AppCompatActivity {

    EditText email, pwd;
    AdminSQL conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg2);
        email = findViewById(R.id.Email_txt);
        pwd = findViewById(R.id.Password_txt);
    }

    private void regUser() {
        conexion = new AdminSQL(this, "Registros", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        if (!email.getText().toString().isEmpty() &&
                !pwd.getText().toString().isEmpty()){
            try {
                ContentValues reg = new ContentValues();
                reg.put("email", email.getText().toString());
                reg.put("password", HashingAlgorithm.hashing(pwd.getText().toString()));
                db.insert("Registros", null, reg);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "No se realizo el registro", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Algun Campo esta Vacio No se registro el contacto", Toast.LENGTH_LONG).show();
        }
        db.close();
        limpiar();
    }

    private void limpiar() {
        email.setText("");
        pwd.setText("");
    }

    public void cambiarMain (View view){
        regUser();
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }
}
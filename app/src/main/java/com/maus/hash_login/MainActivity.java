package com.maus.hash_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, pwd;
    AdminSQL conexion;
    String Contrasena,  correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.Email_txt);
        pwd = findViewById(R.id.Password_txt);
    }

    private void Consular(){
        conexion = new AdminSQL(this, "Registros", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        correo = email.getText().toString();
        if (!correo.isEmpty()){
            Cursor fila = db.rawQuery("select password from Registros where email = '"+ correo+"' ", null);
            if (fila.moveToFirst()){
                Contrasena = fila.getString(0);
                db.close();
            }else{
                Toast.makeText(this, "No existe el usuario",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ponga un correo", Toast.LENGTH_LONG).show();
        }

    }


    public void Iniciar(View view){
        Consular();
        Toast.makeText(this, "toso bien "+  pwd.getText().toString()+"  "+Contrasena,Toast.LENGTH_LONG).show();
        if (Contrasena.equals(HashingAlgorithm.hashing(pwd.getText().toString()))){
            Intent intent= new Intent(this, Sesion.class);
            intent.putExtra("1", correo);
            intent.putExtra("2", Contrasena);
            intent.putExtra("3",pwd.getText().toString());

            startActivity(intent);
        }else{
            Toast.makeText(this, "Error en la contraseña",Toast.LENGTH_SHORT).show();
        }

    }
    public void registrar(View view){
        Intent intent= new Intent(this, RegActivity2.class);
        startActivity(intent);
    }

}
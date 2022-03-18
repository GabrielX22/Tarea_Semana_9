package com.example.tareasemana9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText usuario;
private EditText contra;
private ImageButton sesion;
private String usu;
private String contrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.edtusuario);
        contra = findViewById(R.id.edtcontra);
        sesion = findViewById(R.id.btnsesion);
        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usu = usuario.getText().toString();
                contrasenia = contra.getText().toString();
                //usuario: gabrielugb y contraseña: programacion2
                if(usu.equals("gabrielugb") && contrasenia.equals("programacion2")){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    Vibrator variable = (Vibrator)
                            getSystemService(Context.VIBRATOR_SERVICE);
                    variable.vibrate(500);
                }
            }
        });
    }
}
package com.example.tareasemana9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity3 extends AppCompatActivity {
private ImageButton regreso;
private ImageView animacion;
private ImageView animacion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        regreso = findViewById(R.id.imageregresar);
        animacion = findViewById(R.id.imageani);
        animacion2 = findViewById(R.id.imageani2);
        Glide.with(getApplicationContext()).load(R.drawable.anirinku).into(animacion);
        Glide.with(getApplicationContext()).load(R.drawable.anirinku2).into(animacion2);
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
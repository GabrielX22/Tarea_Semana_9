package com.example.tareasemana9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
private EditText para;
private EditText asunto;
private EditText mensaje;
private ImageButton enviar;
private ImageButton desa;
private ImageButton limpiar;
private String par;
private String asun;
private String men;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        para = findViewById(R.id.edtpara);
        asunto = findViewById(R.id.edtasunto);
        mensaje = findViewById(R.id.edtmensaje);
        enviar = findViewById(R.id.imagecorreo);
        desa = findViewById(R.id.imagedesa);
        limpiar = findViewById(R.id.imagelimpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                para.setText("");
                asunto.setText("");
                mensaje.setText("");
            }
        });
        desa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                par = para.getText().toString();
                asun = asunto.getText().toString();
                men = mensaje.getText().toString();
                if(par.equals("") || asun.equals("") || men.equals("")){
                    Toast.makeText(MainActivity2.this, "Llene los campos requeridos", Toast.LENGTH_SHORT).show();
                    Vibrator variable = (Vibrator)
                            getSystemService(Context.VIBRATOR_SERVICE);
                    variable.vibrate(300);
                }
                else{
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,
                            new String[] { par });
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, asun);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, men);
                    emailIntent.setType("message/rfc822");
                    startActivity(Intent.createChooser(emailIntent, "Seleccione una aplicación"));
                }

            }
        });
    }
}
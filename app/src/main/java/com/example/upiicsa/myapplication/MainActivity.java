package com.example.upiicsa.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText numero1,numero2,resultado;
    Button validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = (EditText) findViewById(R.id.number1);
        numero1.setEnabled(false);
        numero2 = (EditText) findViewById(R.id.number2);
        numero2.setEnabled(false);
        resultado = (EditText) findViewById(R.id.resultado);
        validar = (Button) findViewById(R.id.validarbtn) ;

        Random generador = new Random();
        numero1.setText(Integer.toString(generador.nextInt(100)));
        numero2.setText(Integer.toString(generador.nextInt(100)));

        validar.setOnClickListener(validarsuma());

    }

    public View.OnClickListener validarsuma() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resultadonum = Integer.parseInt(numero1.getText().toString()) +  Integer.parseInt(numero2.getText().toString()) ;
                if (resultadonum == Integer.parseInt(resultado.getText().toString() ) ) {
                    Intent intent = new Intent(getApplicationContext(),SuccesfullActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Capcha Incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }


}

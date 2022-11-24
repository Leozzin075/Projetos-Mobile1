package com.example.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class jv_final extends AppCompatActivity {
    Button reiniciar;
    TextView informacao;
    ImageView resultado;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_final);
        reiniciar = findViewById(R.id.reiniciar);
        informacao = findViewById(R.id.informacao);
        resultado = findViewById(R.id.resultado);
        view = findViewById(R.id.view);
        Intent i = getIntent();
        String m1 = i.getStringExtra(jv_quiz.codigo);
        if(m1.equals("passou")){
            view.setBackgroundResource(R.color.Green);
            resultado.setImageResource(R.drawable.ganhou);
            informacao.setText("Parabens voce acertou mais de 60% das perguntas");
        }else if(m1.equals("perdeu")){
            view.setBackgroundResource(R.color.Red);
            resultado.setImageResource(R.drawable.perdeu);
            informacao.setText("ihhh deu mole ein, errou mais de 60% das perguntas");
        }

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }
}
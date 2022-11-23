package com.example.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class jv_quiz extends AppCompatActivity {

    public TextView perguntas;
    public Button r, r1, r2, r3;
    public ProgressBar tempo;
    int i=0;
    private String[] enuciados = {

    };
    private String[] respostas = {

    };
    private int[] respostas_certas = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tela_quiz);
    perguntas = findViewById(R.id.perguntas);
    r = findViewById(R.id.r);
    r1 = findViewById(R.id.r1);
    r2 = findViewById(R.id.r2);
    r3 = findViewById(R.id.r3);
    tempo = findViewById(R.id.tempo);







        //Temporizador
        tempo.setProgress(i);
        new CountDownTimer(15000, 10){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                i++;
                tempo.setProgress((int)(((1.0 * millisUntilFinished) / 15000) * 100));;
            }

            @Override
            public void onFinish() {
            //Descobrir como definir a resposta certa
            //Implementar funçao de quando clicar na reposta resetar o tempo
            //Fazer contador

            }
        }.start();


    }
}

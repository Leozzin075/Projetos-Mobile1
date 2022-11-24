package com.example.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class jv_quiz extends AppCompatActivity implements View.OnClickListener {

    public TextView perguntas;
    public Button r, r1, r2, r3, enviar;
    public ProgressBar tempo;
    int i = 0;
    public static final String codigo = "123";

    int score = 0;
    int totalQuestion = questoes_jv.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_quiz);
        perguntas = findViewById(R.id.perguntas);
        r = findViewById(R.id.r);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        enviar = findViewById(R.id.enviar);
        tempo = findViewById(R.id.tempo);

        r.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        enviar.setOnClickListener(this);


        loadNewQuestion();

        //Temporizador
        tempo.setProgress(i);
        new CountDownTimer(15000, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress" + i + millisUntilFinished);
                i++;
                tempo.setProgress((int) (((1.0 * millisUntilFinished) / 15000) * 100));
                ;
            }

            @Override
            public void onFinish() {
                //Descobrir como definir a resposta certa
                //Implementar funçao de quando clicar na reposta resetar o tempo
                //Fazer contador

            }
        }.start();

    }

    @Override
    public void onClick(View view) {
        r.setBackgroundColor(Color.WHITE);
        r1.setBackgroundColor(Color.WHITE);
        r2.setBackgroundColor(Color.WHITE);
        r3.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.enviar) {
            if (selectedAnswer.equals(questoes_jv.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        } else{
        //choices button clicked
        selectedAnswer  = clickedButton.getText().toString();
        clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        perguntas.setText(questoes_jv.question[currentQuestionIndex]);
        r.setText(questoes_jv.choices[currentQuestionIndex][0]);
        r1.setText(questoes_jv.choices[currentQuestionIndex][1]);
        r2.setText(questoes_jv.choices[currentQuestionIndex][2]);
        r3.setText(questoes_jv.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        if(score > totalQuestion*0.60){
//            passStatus = "Passed";
            Intent sgd;
            String m1 = "passou";
            sgd = new Intent(getApplicationContext(), jv_final.class);
            sgd.putExtra(codigo, m1);
            startActivity(sgd);
        }else{
//            passStatus = "Failed";
            Intent sgd;
            String m1 = "perdeu";
            sgd = new Intent(getApplicationContext(), jv_final.class);
            sgd.putExtra(codigo, m1);
            startActivity(sgd);

        }

//        new AlertDialog.Builder(this)
//                .setTitle(passStatus)
//                .setMessage("Score is "+ score+" out of "+ totalQuestion)
//                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
//                .setCancelable(false)
//                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}

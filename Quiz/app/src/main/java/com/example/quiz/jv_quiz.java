package com.example.quiz;

import static android.os.Build.VERSION_CODES.S;

import static kotlinx.coroutines.DelayKt.delay;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//Fazr a personalizaçao
//ajeitar as repostas
//testar
//implementar algumas figtures novas

public class jv_quiz extends AppCompatActivity implements View.OnClickListener {

    public TextView perguntas;
    public Button r, r1, r2, r3;
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
        tempo = findViewById(R.id.tempo);

        r.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);

        temporizador();
        loadNewQuestion();

    }

    public void temporizador(){
        tempo.setProgress(i);
            new CountDownTimer(50000, 10) {

                @Override
                public void onTick(long millisUntilFinished) {
                    Log.v("Log_tag", "Tick of Progress" + i + millisUntilFinished);
                    i++;
                    tempo.setProgress((int) (((1.0 * millisUntilFinished) / 50000) * 100));
                    ;
                }

                @Override
                public void onFinish() {
                    new AlertDialog.Builder(jv_quiz.this)
                            .setTitle("Perdeu o tempo ein mane")
                            .setMessage("Acabou o tempo amigao volta pro inicio ai dnv")
                            .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                            .setCancelable(false)
                            .show();
                    temporizador();


                }
            }.start();
    }

    public void verificarExpressao(Button s){
        if(selectedAnswer.equals(questoes_jv.correctAnswers[currentQuestionIndex])){
            score++;
        }
        currentQuestionIndex++;
    }

    public void marcarOpcao(Button s){
        selectedAnswer  = s.getText().toString();
        s.setBackgroundColor(Color.MAGENTA);
    }

    @Override
    public void onClick(View view) {
        r.setBackgroundColor(Color.WHITE);
        r1.setBackgroundColor(Color.WHITE);
        r2.setBackgroundColor(Color.WHITE);
        r3.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        switch (clickedButton.getId()){
            case R.id.r:
                marcarOpcao(r);
                verificarExpressao(r);
                loadNewQuestion();
                break;
            case R.id.r1:
                marcarOpcao(r1);
                verificarExpressao(r1);
                loadNewQuestion();
                break;
            case R.id.r2:
                marcarOpcao(r2);
                verificarExpressao(r2);
                loadNewQuestion();
                break;
            case R.id.r3:
                marcarOpcao(r3);
                verificarExpressao(r3);
                loadNewQuestion();
                break;

        }

    }

    void loadNewQuestion(){
        new CountDownTimer(1500, 10) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(currentQuestionIndex == totalQuestion ){
                    finishQuiz();
                    return;
                }


                perguntas.setText(questoes_jv.question[currentQuestionIndex]);
                r.setText(questoes_jv.choices[currentQuestionIndex][0]);
                r1.setText(questoes_jv.choices[currentQuestionIndex][1]);
                r2.setText(questoes_jv.choices[currentQuestionIndex][2]);
                r3.setText(questoes_jv.choices[currentQuestionIndex][3]);

                r.setBackgroundColor(Color.WHITE);
                r1.setBackgroundColor(Color.WHITE);
                r2.setBackgroundColor(Color.WHITE);
                r3.setBackgroundColor(Color.WHITE);

            }
        }.start();


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

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}

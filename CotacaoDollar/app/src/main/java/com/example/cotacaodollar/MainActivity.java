package com.example.cotacaodollar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText cotacao, dollar, real;
    private Button ativar;
    private TextView resultR, resultD;
    DecimalFormat df = new DecimalFormat("##.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cotacao = findViewById(R.id.cotacao);
        dollar = findViewById(R.id.dollar);
        real = findViewById(R.id.real);
        ativar = findViewById(R.id.ativar);
        resultR = findViewById(R.id.resultR);
        resultD = findViewById(R.id.resultD);

        ativar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cot = cotacao.getText().toString();
                String rea = real.getText().toString();
                String dol = dollar.getText().toString();
                double coT = Double.parseDouble(cot);
                double reA = Double.parseDouble(rea);
                double doL = Double.parseDouble(dol);
                double c = doL / coT;
                String valorFormatado = df.format(c);
                resultD.setText(valorFormatado);
                double c1 = reA * coT;
                String valorFormatado1 = df.format(c1);
                resultR.setText(valorFormatado1);


            }
        });






    }
}
package com.example.projetoduplal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView idGasolina, idEtanol, valorResultado;
    private Button calcular_preco, limpar;
    private EditText valorGasolina, valorEtanol;
    private ImageView imgResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idGasolina = findViewById(R.id.idGasolina);
        idEtanol = findViewById(R.id.idEtanol);
        calcular_preco = findViewById(R.id.calcular_preco);
        valorGasolina = findViewById(R.id.valorGasolina);
        valorEtanol = findViewById(R.id.valorEtanol);
        valorResultado = findViewById(R.id.valorResultado);
        limpar = findViewById(R.id.limpar);
        imgResultado = findViewById(R.id.imgResultado1);

        calcular_preco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = valorEtanol.getText().toString();
                String n2 = valorGasolina.getText().toString();
                double nn1 = Double.parseDouble(n1);
                double nn2 = Double.parseDouble(n2);
                double c = nn1/nn2;
                String resultado = null;
                imgResultado.setVisibility(View.VISIBLE);
                imgResultado.setMaxWidth(200);
                imgResultado.setMaxHeight(200);
                if (c > 0.7){
                    resultado = "Abasteça com Gasolina";
                    imgResultado.setBackgroundResource(R.drawable.gasolinaimg);
                } else{
                    resultado = "Abasteça com Etanol";
                    imgResultado.setBackgroundResource(R.drawable.etanolimg);
                }
                valorResultado.setText(resultado);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorGasolina.setText("");
                valorEtanol.setText("");
                valorResultado.setText("");
                imgResultado.setVisibility(View.INVISIBLE);
            }
        });
    }
}
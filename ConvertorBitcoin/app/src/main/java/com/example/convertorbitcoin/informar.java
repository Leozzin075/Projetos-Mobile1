package com.example.convertorbitcoin;

import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class informar extends AppCompatActivity {
    private ImageView web_real, web_dollar;
    private EditText valorBit, valorCal;
    private TextView resultado;
    private Button calcular, limpar, sair;
    private Spinner opcao;
    //Opções do spinner
    String[] menu = {"","Dollar", "Real"};
    //Codigo para passar informaçao para outra tela
    public static final String codigo = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informar_xml);
        web_dollar = findViewById(R.id.web_dollar);
        web_real = findViewById(R.id.web_real);
        valorBit = findViewById(R.id.valor);
        valorCal = findViewById(R.id.valor2);
        resultado = findViewById(R.id.resultado);
        calcular = findViewById(R.id.calcular);
        limpar = findViewById(R.id.limpar);
        sair = findViewById(R.id.sair);
        opcao = findViewById(R.id.opcao);

        //Criando um spinner - começo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, menu);
        opcao.setAdapter(adapter);
        //Criando um spinner - fim

        //Fazendo o spineer funcionar - começo
        opcao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int i, long l) {
                //Verificando se qual opção esta sendo selecionada
                if(menu[i].equals("Real")){
                    //Transformando os valores em String
                    String cReal = valorCal.getText().toString();
                    String cBit = valorBit.getText().toString();
                    if(!cReal.isEmpty()) {
                        calcular.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                    if(cReal.isEmpty() || cBit.isEmpty()){
                                        resultado.setText("Sem valor");
                                    }else{
                                        double vReal = Double.parseDouble(cReal);
                                        double vBit = Double.parseDouble(cBit);
                                        double result = vReal * vBit;
                                        resultado.setText(String.format("%.2f", result));
                                    }

                            }
                        });
                    }
                } else {
                    String cDolar = valorCal.getText().toString();
                    String cBit = valorBit.getText().toString();
                    if(!cDolar.isEmpty()) {
                        calcular.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                double vDolar = Double.parseDouble(cDolar);
                                double vBit = Double.parseDouble(cBit);
                                double result = vDolar * vBit;
                                resultado.setText(String.format("%.2f", result));
                            }
                        });
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                calcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog alerta = new AlertDialog.Builder(informar.this).create();
                        alerta.setTitle("Opaaa");
                        alerta.setMessage("Escolha uma opção amigão!!" );
                        alerta.show();
                    }
                });

            }
        });

        web_real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent web1;
                String m1 = "real";
                web1 = new Intent(getApplicationContext(), pagweb.class);
                web1.putExtra(codigo, m1);
                startActivity(web1);
            }
        });

        web_dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent web;
                String m1 = "dolar";
                web = new Intent(getApplicationContext(), pagweb.class);
                web.putExtra(codigo, m1);
                startActivity(web);
            }
        });


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorBit.setText("");
                valorCal.setText("");
                resultado.setText("");
                //Como "limpar" o spinner
                opcao.setSelection(adapter.getPosition(""));
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(informar.this);
                builder.setMessage("Quer sair do app?");
                builder.setCancelable(true);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();

                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cReal = valorCal.getText().toString();
                String cBit = valorBit.getText().toString();

                if (cReal.isEmpty() || cBit.isEmpty()){
                    AlertDialog alerta = new AlertDialog.Builder(informar.this).create();
                    alerta.setTitle("Ta fora do Brasil irmão?");
                    alerta.setMessage("Viajouu? Passaporte assianado? Ta vendo que ta sem numero não? " );
                    alerta.show();
                }
            }
        });

    }
}
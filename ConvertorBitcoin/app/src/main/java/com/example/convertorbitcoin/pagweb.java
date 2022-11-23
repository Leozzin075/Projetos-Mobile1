package com.example.convertorbitcoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pagweb extends AppCompatActivity {

    private WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_pag);
        w1 = findViewById(R.id.w1);
        Intent i = getIntent();
        String m1 = i.getStringExtra(informar.codigo);
        if(m1.equals("real")){
            w1.loadUrl("https://www.infomoney.com.br/cotacoes/cripto/ativo/bitcoin-btc/");
            WebSettings ww1 = w1.getSettings();
            ww1.setJavaScriptEnabled(true);
        }else if (m1.equals("dolar")){
            w1.loadUrl("https://www.moneytimes.com.br/cotacao/bitcoin-us/");
            WebSettings ww2 = w1.getSettings();
            ww2.setJavaScriptEnabled(true);
        }

    }
}
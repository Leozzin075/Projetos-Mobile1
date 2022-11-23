package com.example.convertorbitcoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button prox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prox = findViewById(R.id.prox);

        prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proximaPagina;
                proximaPagina = new Intent(getApplicationContext(), informar.class);
                startActivity(proximaPagina);
            }
        });
    }
}
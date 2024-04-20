package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {

    private Button btnReiniciar, btnVoltar;

    public TextView txtNome, txtAcertos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
       btnReiniciar = findViewById(R.id.btnReiniciar);
       btnVoltar = findViewById(R.id.btnVoltar);
       txtNome = findViewById(R.id.txtNome);
       txtAcertos = findViewById(R.id.txtAcertos);

        // Recupera a contagem total de respostas corretas usando o método do MyApp
        int totalCorrectAnswersCount = ((MyApp) getApplication()).getCorrectAnswersCount();
        // Exibe a contagem total de respostas corretas em uma TextView
        txtAcertos.setText(String.valueOf(totalCorrectAnswersCount));



        //Nome da pessoa
        MyApp myApp = (MyApp) getApplication();
        String nomeRanking = myApp.getUserName();
        txtNome.setText(nomeRanking);


        // VOLTAR PARA TELA INICIAL
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Ranking.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });

        //RESPONDER O QUIZ NOVAMENTE
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApp) getApplication()).resetCorrectAnswersCount();
                Intent intent = new Intent(Ranking.this, Tela1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
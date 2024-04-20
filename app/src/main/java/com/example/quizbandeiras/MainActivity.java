package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public EditText edtNome;
private Button btnIniciar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);
        edtNome = findViewById(R.id.edtNome);
        //Visão de texto, se está vazio ou preenchido para iniciar o quiz
        edtNome.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {
                if (s.toString().trim().isEmpty()) {
                    btnIniciar.setEnabled(false);
                } else {
                    btnIniciar.setEnabled(true);
                }
           }
       });


      // Fechar o aplicativo
        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        // Iniciar o quiz e enviar o nome do usuário
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeRanking = edtNome.getText().toString();
                MyApp myApp = (MyApp) getApplication();
                myApp.setUserName(nomeRanking);
                Intent intent = new Intent(MainActivity.this, Tela1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
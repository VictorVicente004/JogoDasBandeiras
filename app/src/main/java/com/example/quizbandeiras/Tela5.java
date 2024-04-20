package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela5 extends AppCompatActivity {
    // VARÍAVEIS
    private Button btnSubmit;
    private RadioGroup answerRadio;
    private int correctAnswersCount = 0;
    private String[] correctCountry = {"Indonésia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);
        btnSubmit = findViewById(R.id.btnSubmit);
        answerRadio = findViewById(R.id.answerRadio);


        answerRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    // Alguma opção foi selecionada, habilitar o botão de resposta
                    btnSubmit.setEnabled(true);
                } else {
                    // Nenhuma opção selecionada, desabilitar o botão de resposta
                    btnSubmit.setEnabled(false);
                }
            }
        });
        // CHAMAR PRÓXIMA TELA
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                Intent intent = new Intent(Tela5.this, Tela6.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Método para verificar se a resposta está incorreta
    private void checkAnswer(){
        // Obtém o ID do RadioButton selecionado
        int selectedRadioButtonId = answerRadio.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            // Obtém o RadioButton selecionado
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            // Obtém o texto do RadioButton selecionado
            String userAnswer = selectedRadioButton.getText().toString();

            // Verifica se a resposta do usuário está correta
            boolean isCorrect = false;
            for (String correct : correctCountry) {
                if (userAnswer.equals(correct)) {
                    isCorrect = true;
                    break;
                }
            }

            // Aqui você pode fazer o que precisa com o resultado
            if (isCorrect) {
                // A resposta está correta
                ((MyApp) getApplication()).incrementCorrectAnswersCount();
                // Você pode fazer algo aqui, como exibir uma mensagem ou salvar o resultado
            }
        }
    }
}
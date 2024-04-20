package com.example.quizbandeiras;

import android.app.Application;

public class MyApp extends Application {
    //IMPLEMENTAÇÃO DO CONTADOR GLOBAL
    private int correctAnswersCount = 0;

    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }
    // Método para contar os acertos
        public void incrementCorrectAnswersCount() {
            correctAnswersCount++;
        }
    // Método para redefinir a contagem de respostas corretas (zerar o contador)
    public void resetCorrectAnswersCount() {
        correctAnswersCount = 0;
        }

        //Receber nome do usuário

        private String userName;
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
            }
        }



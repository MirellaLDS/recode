package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tela_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String mensagemRecebida = getIntent().getStringExtra("CHAVE_MENSAGEM");

        TextView tvMessage = findViewById(R.id.tv_recibida2);
        tvMessage.setText(mensagemRecebida);

    }
}
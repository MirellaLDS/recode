package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tela_2Activity extends AppCompatActivity {

    public final static String KEY_INTENT_TELA2 = "Mensagem_tela_2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String mensagemRecebida = getIntent().getStringExtra(Tela_1Activity.KEY_INTENT_TELA1);

        TextView tvMessage = findViewById(R.id.tv_recibida2);
        tvMessage.setText(mensagemRecebida);

    }
}
package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela_1Activity extends AppCompatActivity {

    public final static String KEY_INTENT_TELA1 = "CHAVE_MENSAGEM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ed_mensagem = findViewById(R.id.ed_mensagem);
        Button button = findViewById(R.id.bt_enviar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_1Activity.this, Tela_2Activity.class);

                String texto = ed_mensagem.getText().toString();
                intent.putExtra(KEY_INTENT_TELA1, texto);

                // Abrir uma tela sem esperar uma resposta
//                startActivity(intent);

                // Abrir uma tela esperando uma resposta
//                startActivityForResult(/*  Conteudo que tem aqui !!!!!!!!!!!!!!!!!*/);
            }
        });

    }
}
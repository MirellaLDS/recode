package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity1 extends AppCompatActivity {

    private EditText edEntradaTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = findViewById(R.id.btSend);
        TextView tvMensagem = findViewById(R.id.mensagem);
        edEntradaTexto =  findViewById(R.id.entradaTexto);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("KEY_MESSAGE", mensagem);

                startActivity(intent);
            }
        });
    }
}
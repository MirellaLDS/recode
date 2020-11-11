package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    TextView textViewMessage;

    public static final String KEY_RESPOSTA = "RESPOSTA";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.entradaTexto2);
        textViewMessage = findViewById(R.id.respostaTela2);
        Button button = findViewById(R.id.btSend2);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);

//        String mensagem = getIntent().getStringExtra(MainActivity1.TAG_KEY_MESSAGE);


        String mensagem = sharedPreferences.getString(MainActivity1.KEY_TELA_1, "Não existe valor para a chave");

        textViewMessage.setText(mensagem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String value = editText.getText().toString();
//                intent.putExtra(KEY_RESPOSTA, value);
//                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
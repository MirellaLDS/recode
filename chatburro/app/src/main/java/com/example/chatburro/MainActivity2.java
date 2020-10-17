package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    TextView textViewMessage;
    public static int RESULT_CODE_REPLY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.entradaTexto2);
        textViewMessage = findViewById(R.id.mensagem2);
        Button button = findViewById(R.id.btSend2);

        String mensagem = getIntent().getStringExtra("KEY_MESSAGE");
        textViewMessage.setText(mensagem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String value = editText.getText().toString();
                intent.putExtra("resposta", value);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


//        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
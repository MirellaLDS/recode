package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.stetho.Stetho;

public class MainActivity1 extends AppCompatActivity {

    private EditText edEntradaTexto;
    SharedPreferences sharedPref;
    TextView tvMensagem;

    private static final String LOG_TAG = MainActivity1.class.getSimpleName();
    private static final String TAG_PREFERENCES = MainActivity1.class.getSimpleName();
    private static final String TAG_KEY_MESSAGE = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        sharedPref = this.getSharedPreferences(TAG_PREFERENCES, Context.MODE_PRIVATE);

        Button botao = findViewById(R.id.btSend);
        tvMensagem = findViewById(R.id.mensagem);
        edEntradaTexto =  findViewById(R.id.entradaTexto);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("KEY_MESSAGE", mensagem);

                // SALVANDO DADOS
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(TAG_KEY_MESSAGE, mensagem);
                editor.apply();

                startActivityForResult(intent, 1000);
            }
        });

        Log.i(LOG_TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "onResume");
        // RECUPERANDO DADOS
        String value = sharedPref.getString("MESSAGE", "Não existe valor para essa key");
        tvMensagem.setText(value);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "onDestroy");
    }
}
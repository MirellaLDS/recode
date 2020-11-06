package com.example.chatburro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    TextView tvMensagem2;

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
        tvMensagem2 = findViewById(R.id.mensagem2);
        edEntradaTexto =  findViewById(R.id.entradaTexto);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("KEY_MESSAGE", mensagem);

                // SALVANDO DADOS
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("MESSAGE_KEY", mensagem);
                editor.apply();

                startActivityForResult(intent, 1000);
            }
        });

        Log.i(LOG_TAG, "onCreate");
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1000) {
//            if (resultCode == Activity.RESULT_OK) {
//
//            }
//        }
//    }

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
        String value1 = sharedPref.getString("MESSAGE_KEY", "Não existe valor para essa key");
        String value2 = sharedPref.getString("MESSAGE", "Não existe valor para essa key");
        tvMensagem.setText(value1 + " \n" + value2);
//        tvMensagem2.setText(value2);
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
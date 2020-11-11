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

public class MainActivity1 extends AppCompatActivity {

    private EditText edEntradaTexto;
    TextView tvMensagem;
    TextView tvResposta;

    private String valor;

    private SharedPreferences sharedPreferences;

    private static final String LOG_TAG = MainActivity1.class.getSimpleName();

    public static final String TAG_KEY_MESSAGE = "MESSAGE_KEY";
    public static final String KEY_TELA_1 = "Key_Tela_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("TAG_PREFERENCES", Context.MODE_PRIVATE);

        Button botao = findViewById(R.id.btSend);
        tvMensagem = findViewById(R.id.mensagem);
        tvResposta = findViewById(R.id.respostaTela1);
        edEntradaTexto =  findViewById(R.id.entradaTexto);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
//                intent.putExtra(TAG_KEY_MESSAGE, mensagem);
                if (!mensagem.isEmpty()) {
                    tvMensagem.setText(mensagem);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_TELA_1, mensagem);
                    editor.apply();
                }

//                startActivityForResult(intent, 1000);
                startActivity(intent);
            }
        });

        Log.i(LOG_TAG, "onCreate");
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1000) {
//            if (resultCode == Activity.RESULT_OK) {
//                String resposta = data.getStringExtra(MainActivity2.KEY_RESPOSTA);
//                tvResposta.setText(resposta);
//            }
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "onStart");
        valor = sharedPreferences.getString(KEY_TELA_1, "Não tem nada no banco");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "onResume");
        tvMensagem.setText(valor);
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
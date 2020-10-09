package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String mensagem = getIntent().getStringExtra("KEY_MESSAGE");

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();


    }
}
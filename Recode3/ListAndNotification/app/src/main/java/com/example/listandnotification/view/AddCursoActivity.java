package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listandnotification.R;
import com.example.listandnotification.model.Curso;
import com.example.listandnotification.repository.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCursoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_curso);

        Button sendButton = findViewById(R.id.bt_send);
        EditText valueTxt = findViewById(R.id.tv_name_course);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitConfig retrofitConfig = new RetrofitConfig();
                String valor = valueTxt.getText().toString();

                Call<Curso> insertRequestCall = retrofitConfig.getCursoService().insert(new Curso(valor));

                insertRequestCall.enqueue(new Callback<Curso>() {
                    @Override
                    public void onResponse(Call<Curso> call, Response<Curso> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Curso> call, Throwable t) {
                        Toast.makeText(AddCursoActivity.this, "Falha na request", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



    }
}
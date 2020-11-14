package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listandnotification.model.Curso;
import com.example.listandnotification.R;
import com.example.listandnotification.repository.RetrofitConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Curso> listaCurso;
    private ArrayAdapter gerenciador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Referencia item da tela
        ListView listView = findViewById(R.id.listView);


        listaCurso = new ArrayList<>();
        gerenciador = new CursoAdapter(this, R.layout.item_view, listaCurso);

        listView.setAdapter(gerenciador);


        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Curso>> call = retrofitConfig.getCursoService().getAllCourses();

        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                List<Curso> cursos = response.body();


                ArrayList<Curso> novalista = new ArrayList<>(cursos);
                listaCurso.addAll(novalista);

                gerenciador.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Sua request falhou!", Toast.LENGTH_LONG).show();
            }
        });



    }
}
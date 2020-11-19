package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listandnotification.model.Curso;
import com.example.listandnotification.R;
import com.example.listandnotification.repository.CourseRepository;
import com.example.listandnotification.repository.ResultCourse;

import java.util.ArrayList;
import java.util.List;

public class CursosActivity extends AppCompatActivity {

    ArrayList<Curso> listaCurso;
    private ArrayAdapter gerenciador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia item da tela
        ListView listView = findViewById(R.id.listView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(CursosActivity.this, AddCursoActivity.class);
                startActivity(intent);
            }
        });

        listaCurso = new ArrayList<>();
        gerenciador = new CursoAdapter(this, R.layout.item_view, listaCurso);

        listView.setAdapter(gerenciador);
    }

    @Override
    protected void onResume() {
        super.onResume();

        CourseRepository repository = new CourseRepository();
        repository.sendRequetCourse(new ResultCourse() {
            @Override
            public void sucesso(List<Curso> cursoList) {
                listaCurso.addAll(cursoList);

                gerenciador.notifyDataSetChanged();
            }

            @Override
            public void falha() {
                Toast.makeText(CursosActivity.this, "Sua request falhou", Toast.LENGTH_LONG).show();
            }
        });
    }
}
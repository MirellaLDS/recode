package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listandnotification.model.Curso;
import com.example.listandnotification.R;
import com.example.listandnotification.repository.CourseRepository;
import com.example.listandnotification.repository.ResultCourse;
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


        CourseRepository repository = new CourseRepository();
        repository.sendRequetCourse(new ResultCourse() {
            @Override
            public void sucesso(List<Curso> cursoList) {
                listaCurso.addAll(cursoList);

                gerenciador.notifyDataSetChanged();
            }

            @Override
            public void falha() {
                Toast.makeText(MainActivity.this, "Sua request falhou", Toast.LENGTH_LONG).show();
            }
        });


    }
}
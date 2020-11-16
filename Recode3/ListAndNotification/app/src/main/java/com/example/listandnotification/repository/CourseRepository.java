package com.example.listandnotification.repository;

import android.widget.Toast;

import com.example.listandnotification.model.Curso;
import com.example.listandnotification.view.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {

    public void sendRequetCourse(ResultCourse resultCourse) {

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Curso>> call = retrofitConfig.getCursoService().getAllCourses();

        final List<Curso>[] resposta = new List[]{new ArrayList<>()};

        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                List<Curso> cursos = response.body();

                ArrayList<Curso> novalista = new ArrayList<>(cursos);

                resultCourse.sucesso(novalista);

            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                resultCourse.falha();
            }
        });
    }


}

package com.example.listandnotification.repository;

import com.example.listandnotification.model.Curso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {

    public void sendRequetCourse(ResultCourseInterface resultCourseInterface) {

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Curso>> call = retrofitConfig.getCursoService().getAllCourses();

        final List<Curso>[] resposta = new List[]{new ArrayList<>()};

        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                List<Curso> cursos = response.body();

                ArrayList<Curso> novalista = new ArrayList<>(cursos);

                resultCourseInterface.sucesso(novalista);

            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                resultCourseInterface.falha();
            }
        });
    }


}

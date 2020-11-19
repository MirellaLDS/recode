package com.example.listandnotification.service;

import com.example.listandnotification.model.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CursoService {

    @GET("course")
    Call<List<Curso>> getAllCourses();

    @POST("course")
    Call<Curso> insert(@Body Curso curso);



    @GET("course")
    Call<Curso> getCurso();

    @PUT("course")
    void update();

    @DELETE("course")
    void delete();

}

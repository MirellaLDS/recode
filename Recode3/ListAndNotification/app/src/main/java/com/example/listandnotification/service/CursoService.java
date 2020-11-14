package com.example.listandnotification.service;

import com.example.listandnotification.model.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CursoService {

    @GET("course")
    Call<List<Curso>> getAllCourses();

    @GET("course")
    Call<Curso> getCurso();

    @POST("course")
    void insert();

    @DELETE("course")
    void delete();



}

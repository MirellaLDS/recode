package com.example.listandnotification.service;

import com.example.listandnotification.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfessorService {

    @GET("professor")
    Call<List<Professor>> getAllProfessors();

}

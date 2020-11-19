package com.example.listandnotification.repository;

import com.example.listandnotification.service.CursoService;
import com.example.listandnotification.service.ProfessorService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CursoService getCursoService(){
        return retrofit.create(CursoService.class);
    }

    public ProfessorService getProfessorService() {
        return retrofit.create(ProfessorService.class);
    }


}

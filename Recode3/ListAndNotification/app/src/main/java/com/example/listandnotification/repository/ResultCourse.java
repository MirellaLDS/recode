package com.example.listandnotification.repository;

import com.example.listandnotification.model.Curso;

import java.util.List;

public interface ResultCourse {
    void sucesso(List<Curso> cursoList);
    void falha();
}

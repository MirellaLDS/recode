package com.example.listandnotification.repository;

import com.example.listandnotification.model.Curso;

import java.util.List;

public interface ResultCourseInterface {
    void sucesso(List<Curso> cursoList);
    void falha();
}

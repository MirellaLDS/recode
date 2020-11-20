package com.example.listandnotification.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.listandnotification.model.Curso;

import java.util.List;

@Dao
public interface CourseDAO {

    @Query("Select * from Course")
    List<Curso> selectAll();

//    @Query("Select * from Course where id")
//    List<Curso> selectById(int id);

    @Insert
    void insertAll(List<Curso> cursoList);

    @Insert
    void insert(Curso curso);

}

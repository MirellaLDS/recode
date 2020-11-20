package com.example.listandnotification.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Course")
public class Curso {

    @PrimaryKey
    private int id;
    private String name;

    public Curso() {
    }

    public Curso(String name) {
        this.name = name;
    }

    public Curso(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

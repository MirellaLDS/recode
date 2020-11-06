package com.example.retrofitconnection.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Departament")
public class Departamento implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int local_id;
    @ColumnInfo(name = "server_id")
    private int id;
    private String name;

    public Departamento() {
    }

    public Departamento(String name) {
        this.name = name;
    }
    public Departamento(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
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

    public static class DepartamentoDTO {
        private int id;

        public DepartamentoDTO(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}


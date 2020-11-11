package com.example.retrofitconnection.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(tableName = "Professor")
@JsonIgnoreProperties({"local_id"})
public class Professor {

    @PrimaryKey(autoGenerate = true)
    private int local_id;
    @ColumnInfo(name = "server_id")
    private int id;
    private String name;
    private String cpf;
//    @Ignore
    Departamento departament = new Departamento();

    public Professor() {
    }

    @Override
    public String toString() {
        return name;
    }

    public Professor(String name, String cpf, Departamento departament) {
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Departamento getDepartament() {
        return departament;
    }

    public void setDepartament(Departamento departament) {
        this.departament = departament;
    }
    public static class ProfessorDTO {
        private String name;
        private String cpf;
        private Departamento.DepartamentoDTO dto;

        public ProfessorDTO(int id, String name, String cpf, Departamento.DepartamentoDTO dto) {
            this.name = name;
            this.cpf = cpf;
            this.dto = dto;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public Departamento.DepartamentoDTO getDto() {
            return dto;
        }

        public void setDto(Departamento.DepartamentoDTO dto) {
            this.dto = dto;
        }
    }

}

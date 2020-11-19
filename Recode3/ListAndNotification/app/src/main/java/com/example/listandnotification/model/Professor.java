package com.example.listandnotification.model;

public class Professor {

    private long id;
    private String name;
    private String cpf;
    private Departament departament;

    public Professor() {
    }

    public Professor(String name, String cpf, Departament departament) {
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
    }

    public Professor(int id, String name, String cpf, Departament departament) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.example.retrofitconnection.model;

public class Departamento {

//            "departament": {
//                "id": 271,
//                "name": "DP 1"
//            }

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


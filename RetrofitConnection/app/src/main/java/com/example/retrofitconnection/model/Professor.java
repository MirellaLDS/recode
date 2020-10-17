package com.example.retrofitconnection.model;

public class Professor {

    //    {
//        "id": 301,
//         "name": "KEVEN LEONE DOS SANTOS",
//         "cpf": "111",
//            "departament": {
//                "id": 271,
//                "name": "DP 1"
//            }
//    }

    private int id;
    private String name;
    private String cpf;
    Departamento departament;

    public Professor() {
    }

    public Professor(String name, String cpf, Departamento departament) {
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
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

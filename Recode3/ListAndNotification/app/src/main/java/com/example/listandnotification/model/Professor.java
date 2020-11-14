package com.example.listandnotification.model;

public class Professor {

    private String nome;
    private String cursoName;
    private String cpf;
    private String urlImagem;

    public Professor() {
    }

    public Professor(String nome, String cursoName, String cpf, String urlImagem) {
        this.nome = nome;
        this.cursoName = cursoName;
        this.cpf = cpf;
        this.urlImagem = urlImagem;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCursoName() {
        return cursoName;
    }

    public void setCursoName(String cursoName) {
        this.cursoName = cursoName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return nome;
    }
}

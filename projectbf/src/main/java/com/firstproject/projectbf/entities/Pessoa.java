package com.firstproject.projectbf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa_projectbf")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private double altura;
    private double salario;

    public Pessoa(){

    }

    public Pessoa(Long id, String nome, int idade, double altura, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

package com.firstproject.projectbf.entities;

import jakarta.persistence.*;

/**
 * Classe que representa uma Pessoa.
 * Entidade mapeada para a tabela "projectbf" no banco de dados.
 */
@Entity
@Table(name = "projectbf")
public class Pessoa {

    //Campos da entidade - Pessoa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Nome da pessoa.
    private String nome;
    //Idade da Pessoa.
    private int idade;
    //Altura da pessoa.
    private double altura;
    //Salário da pessoa.
    private double salario;

    /**
     * Construtor da classe Pessoa - vazio.
     * Necessário caso precise instanciar sem passar nenhuma informação.
     */
    public Pessoa(){
    }

    /**
     * Construtor da classe Pessoa - com parâmetros.
     *
     * @param id      ID da pessoa.
     * @param nome    Nome da pessoa.
     * @param idade   Idade da pessoa.
     * @param altura  Altura da pessoa.
     * @param salario Salário da pessoa.
     */
    public Pessoa(Long id, String nome, int idade, double altura, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.salario = salario;
    }

    //Getters e Setters - abaixo

    /**
     * Pega o ID da pessoa.
     *
     * @return O ID da pessoa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da pessoa.
     *
     * @param id O ID da pessoa a ser definido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pega o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome O nome da pessoa a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Pega a idade da pessoa.
     *
     * @return A idade da pessoa.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa.
     *
     * @param idade A idade da pessoa a ser definida.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Pega a altura da pessoa.
     *
     * @return A altura da pessoa.
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Define a altura da pessoa.
     *
     * @param altura A altura da pessoa a ser definida.
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Pega o salário da pessoa.
     *
     * @return O salário da pessoa.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Define o salário da pessoa.
     *
     * @param salario O salário da pessoa a ser definido.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
}


package com.firstproject.projectbf.service;

import com.firstproject.projectbf.entities.Pessoa;
import com.firstproject.projectbf.repositories.PessoaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service responsável por operações relacionadas a entidade Pessoa.
@Component
public class PessoaService {

    @Autowired
    private PessoaRepositories pessoaRepositories;

    /**
     * Cria uma nova pessoa no sistema.
     *
     * @param pessoa A pessoa a ser criada.
     */
    @Transactional
    public void criarPessoa(Pessoa pessoa) {
        pessoaRepositories.save(pessoa);
    }

    /**
     * Exclui uma pessoa do sistema.
     *
     * @param pessoa A pessoa a ser excluída.
     */
    @Transactional
    public void excluirPessoa(Pessoa pessoa) {
        pessoaRepositories.delete(pessoa);
    }

    /**
     * Busca todas as pessoas que contenham o nome especificado (ignorando maiúsculas e minúsculas).
     *
     * @param nome O nome a ser pesquisado.
     * @return Uma lista de pessoas que contenham o nome especificado.
     */
    @Transactional
    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return pessoaRepositories.buscaPessoasEspecificasPorNome(nome);
    }
}

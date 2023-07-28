package com.firstproject.projectbf.service;

import com.firstproject.projectbf.entities.Pessoa;
import com.firstproject.projectbf.repositories.PessoaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PessoaService {

    @Autowired
    private PessoaRepositories pessoaRepositories;

    @Transactional
    public void criarPessoa(Pessoa pessoa) {
        pessoaRepositories.save(pessoa);
    }

    @Transactional
    public void excluirPessoa(Pessoa pessoa) {
        pessoaRepositories.delete(pessoa);
    }

    @Transactional(readOnly = true) //(readOnly = true) habilitado apenas para leitura
    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return pessoaRepositories.findByNomeContainingIgnoreCase(nome);
    }
}

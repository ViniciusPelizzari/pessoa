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

    @Transactional(readOnly = true)
    public void criarPessoa(Pessoa pessoa) {
        pessoaRepositories.save(pessoa);
    }

    /*@Transactional(readOnly = true)
    public void criarPessoa(Pessoa pessoa) {
        try {
            pessoaRepositories.save(pessoa);
        } catch (Exception exception) {
            throw new PessoaException("Erro ao criar pessoa. Verifique os dados e tente novamente.");
        }
    }*/

    @Transactional(readOnly = true)
    public void excluirPessoa(Pessoa pessoa) {
        pessoaRepositories.delete(pessoa);
    }

    /*@Transactional(readOnly = true)
    public void excluirPessoa(Pessoa pessoa) {
        try {
            pessoaRepositories.delete(pessoa);
        } catch (Exception exception) {
            throw new PessoaException("Erro ao excluir pessoa. Verifique os dados e tente novamente.");
        }
    }*/

    @Transactional(readOnly = true)
    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return pessoaRepositories.findByNomeContainingIgnoreCase(nome);
    }

    @Transactional(readOnly = true)
    public List<Pessoa> buscarPessoasComSalarioMaiorQue(double salario) {
        return pessoaRepositories.findBySalarioGreaterThan(salario);
    }

    @Transactional(readOnly = true)
    public List<Pessoa> buscarPessoasPorIdade(int idade) {
        return pessoaRepositories.findAllByOrderByIdadeAsc(idade);
    }
}

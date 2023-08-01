package com.firstproject.projectbf.repositories;

import com.firstproject.projectbf.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repositório de dados para a entidade Pessoa.
@Repository //não tinha
public interface PessoaRepositories extends JpaRepository<Pessoa, Long> {

    /**
     * Busca todas as pessoas que contenham o nome especificado (ignorando maiúsculas e minúsculas).
     *
     * @param nome O nome a ser pesquisado.
     * @return Uma lista de pessoas que contenham o nome especificado.
     */
    @Query("SELECT p FROM Pessoa p WHERE p.nome LIKE %:nome%")
    List<Pessoa> buscaPessoasEspecificasPorNome(String nome);
}

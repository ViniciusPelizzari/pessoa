package com.firstproject.projectbf.repositories;

import com.firstproject.projectbf.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //não tinha
public interface PessoaRepositories extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p WHERE p.nome = :nome")
    List<Pessoa> findByNome(String nome);

    @Query("SELECT p FROM Pessoa p WHERE p.nome LIKE %:nome%")
    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}

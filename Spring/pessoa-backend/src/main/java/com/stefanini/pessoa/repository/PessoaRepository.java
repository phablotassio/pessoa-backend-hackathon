package com.stefanini.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.pessoa.entidades.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}

package com.stefanini.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.pessoa.entidades.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

}

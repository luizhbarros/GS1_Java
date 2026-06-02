package com.fiap._emr.GS1_Java.repository;

import com.fiap._emr.GS1_Java.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    // O JpaRepository já traz métodos prontos como save(), findAll(), findById() e deleteById()
}

package com.fiap._emr.GS1_Java.service;

import com.fiap._emr.GS1_Java.model.Recurso;
import com.fiap._emr.GS1_Java.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository repository;

    // Retorna todos os recursos cadastrados
    public List<Recurso> listarTodos() {
        return repository.findAll();
    }

    // Busca um recurso específico pelo ID
    public Optional<Recurso> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Cria um novo recurso ou atualiza um existente
    public Recurso salvar(Recurso recurso) {
        return repository.save(recurso);
    }

    // Remove um recurso pelo ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

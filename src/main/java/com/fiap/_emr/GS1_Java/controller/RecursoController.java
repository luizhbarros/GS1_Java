package com.fiap._emr.GS1_Java.controller;

import com.fiap._emr.GS1_Java.model.Recurso;
import com.fiap._emr.GS1_Java.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    private RecursoService service;

    // READ: Lista todos os recursos
    @GetMapping
    public ResponseEntity<List<Recurso>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // READ: Busca um recurso específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Recurso> buscarPorId(@PathVariable Long id) {
        Optional<Recurso> recurso = service.buscarPorId(id);
        return recurso.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE: Cadastra um novo recurso
    @PostMapping
    public ResponseEntity<Recurso> criar(@RequestBody Recurso recurso) {
        Recurso novoRecurso = service.salvar(recurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRecurso);
    }

    // UPDATE: Atualiza os dados de um recurso existente
    @PutMapping("/{id}")
    public ResponseEntity<Recurso> atualizar(@PathVariable Long id, @RequestBody Recurso recursoAtualizado) {
        Optional<Recurso> recursoExistente = service.buscarPorId(id);

        if (recursoExistente.isPresent()) {
            Recurso recurso = recursoExistente.get();
            recurso.setNome(recursoAtualizado.getNome());
            recurso.setTipo(recursoAtualizado.getTipo());
            recurso.setCapacidadeTotal(recursoAtualizado.getCapacidadeTotal());
            recurso.setNivelAtual(recursoAtualizado.getNivelAtual());
            recurso.setUnidadeMedida(recursoAtualizado.getUnidadeMedida());

            return ResponseEntity.ok(service.salvar(recurso));
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE: Remove um recurso pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Recurso> recursoExistente = service.buscarPorId(id);

        if (recursoExistente.isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}

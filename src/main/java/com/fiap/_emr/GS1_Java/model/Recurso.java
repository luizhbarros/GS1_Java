package com.fiap._emr.GS1_Java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_recursos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome; // Ex: Painel Solar Principal, Tanque de Água A

    @Column(nullable = false)
    private String tipo; // Ex: Energia, Água, Climatização

    @Column(nullable = false)
    private Double capacidadeTotal;

    @Column(nullable = false)
    private Double nivelAtual;

    @Column(nullable = false)
    private String unidadeMedida; // Ex: kW, Litros, %

    // Construtor vazio exigido pelo JPA
    public Recurso() {}

    // Construtor com argumentos
    public Recurso(String nome, String tipo, Double capacidadeTotal, Double nivelAtual, String unidadeMedida) {
        this.nome = nome;
        this.tipo = tipo;
        this.capacidadeTotal = capacidadeTotal;
        this.nivelAtual = nivelAtual;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getCapacidadeTotal() { return capacidadeTotal; }
    public void setCapacidadeTotal(Double capacidadeTotal) { this.capacidadeTotal = capacidadeTotal; }

    public Double getNivelAtual() { return nivelAtual; }
    public void setNivelAtual(Double nivelAtual) { this.nivelAtual = nivelAtual; }

    public String getUnidadeMedida() { return unidadeMedida; }
    public void setUnidadeMedida(String unidadeMedida) { this.unidadeMedida = unidadeMedida; }
}
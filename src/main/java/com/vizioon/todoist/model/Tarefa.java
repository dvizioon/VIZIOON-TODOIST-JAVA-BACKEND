package com.vizioon.todoist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDate lembrete;

    public Tarefa() {
    }

    public Tarefa(String nome, String descricao, LocalDate lembrete) {
        this.nome = nome;
        this.descricao = descricao;
        this.lembrete = lembrete;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getLembrete() {
        return lembrete;
    }

    public void setLembrete(LocalDate lembrete) {
        this.lembrete = lembrete;
    }
}

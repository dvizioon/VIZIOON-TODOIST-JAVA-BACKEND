package com.br.aula.h2.controller;

import com.br.aula.h2.model.Tarefa;
import com.br.aula.h2.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/tarefa")
@RestController
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // GET /api/tarefa -> lista todas
    @GetMapping
    public List<Tarefa> getTarefas(){
        return tarefaRepository.findAll();
    }

    // GET /api/tarefa/{id} -> busca uma específica
    @GetMapping("/{id}")
    public Optional<Tarefa> getTarefaPorId(@PathVariable Long id){
        return tarefaRepository.findById(id);
    }

    // POST /api/tarefa -> cria uma nova
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    // DELETE /api/tarefa/{id} -> apaga
    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaRepository.deleteById(id);
    }
}
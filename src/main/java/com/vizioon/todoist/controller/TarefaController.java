package com.vizioon.todoist.controller;

import com.vizioon.todoist.model.Tarefa;
import com.vizioon.todoist.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/tarefa")
@RestController
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> getTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> getTarefaPorId(@PathVariable Long id) {
        return tarefaRepository.findById(id);
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa dados) {
        Tarefa tarefa = tarefaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada: " + id));
        tarefa.setNome(dados.getNome());
        tarefa.setDescricao(dados.getDescricao());
        tarefa.setLembrete(dados.getLembrete());
        return tarefaRepository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}

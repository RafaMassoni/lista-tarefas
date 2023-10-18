package br.com.rafael.listatarefas.controllers;


import br.com.rafael.listatarefas.mapper.TarefaMapper;
import br.com.rafael.listatarefas.model.Tarefa;
import br.com.rafael.listatarefas.model.TarefaRequest;
import br.com.rafael.listatarefas.model.TarefaResponse;
import br.com.rafael.listatarefas.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarefa")
public class TarefasController {

    @Autowired
    private TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefaResponse> criarTarefa(@Validated @RequestBody TarefaRequest tarefaRequest) {

        Tarefa tarefa = TarefaMapper.mapToTarefa(tarefaRequest);
        tarefa = tarefasService.criarTarefa(tarefa);
        TarefaResponse tarefaResponse = TarefaMapper.mapToResponse(tarefa);

        return ResponseEntity.ok(tarefaResponse);
    }



    @GetMapping
    public ResponseEntity<List<TarefaResponse>> exibirTodasTarefas() {

        List<Tarefa> listaTarefas = tarefasService.buscarTodos();

        List<TarefaResponse> listaTarefasResponse = listaTarefas.stream()
                .map(TarefaMapper::mapToResponse)
                .toList();

        return ResponseEntity.ok(listaTarefasResponse);
    }

    @PutMapping("/{idTarefa}")
    public ResponseEntity<TarefaResponse> atualizarTarefa(@Validated @RequestBody TarefaRequest tarefaRequest,
                                                   @PathVariable Integer idTarefa) {

        Tarefa tarefa = TarefaMapper.mapToTarefa(tarefaRequest);
        tarefa.setId(idTarefa);

        tarefa = tarefasService.atualizarTarefa(tarefa);
        TarefaResponse tarefaResponse = TarefaMapper.mapToResponse(tarefa);

        return ResponseEntity.ok(tarefaResponse);
    }

    @DeleteMapping("/{idTarefa}")
    public ResponseEntity<Void> removerPorId(@PathVariable Integer idTarefa) {

        tarefasService.removerTarefa(idTarefa);

        return ResponseEntity.ok().build();
    }


}

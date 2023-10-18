package br.com.rafael.listatarefas.services;

import br.com.rafael.listatarefas.model.Tarefa;
import br.com.rafael.listatarefas.model.TarefaRequest;
import br.com.rafael.listatarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {


    @Autowired
    private TarefaRepository tarefaRepository;
    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.inserir(tarefa);
    }
    public Tarefa atualizarTarefa(Tarefa tarefa) {
        return tarefaRepository.atualizar(tarefa);
    }
    public void removerTarefa(int idTarefa) {
        tarefaRepository.removerPorId(idTarefa);
    }
    public List<Tarefa> buscarTodos() {
        return tarefaRepository.buscarTodos();
    }
}

package br.com.rafael.listatarefas.repository;

import br.com.rafael.listatarefas.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TarefaRepository {


    private static int ultimoIdUtilizado = 0;
    private static final Map<Integer, Tarefa> mapTarefas = new HashMap<>();

    public Tarefa inserir(Tarefa tarefa)
    {
        int novoId = ++ultimoIdUtilizado;

        Tarefa tarefaComId = tarefa.withId(novoId);
        mapTarefas.put(novoId,tarefaComId);

        return tarefaComId;
    }


    public Tarefa atualizar(Tarefa tarefa)
    {

        Integer idTarefa = tarefa.getId();
        mapTarefas.put(idTarefa,tarefa);

        return tarefa;
    }

    public List<Tarefa> buscarTodos()
    {
        Collection<Tarefa> listaTarefas = mapTarefas.values();
        return new ArrayList<>(listaTarefas);
    }
    public void removerPorId(int idTarefa)
    {
        mapTarefas.remove(idTarefa);
    }

}

package br.com.rafael.listatarefas.mapper;

import br.com.rafael.listatarefas.model.Tarefa;
import br.com.rafael.listatarefas.model.TarefaRequest;
import br.com.rafael.listatarefas.model.TarefaResponse;
import org.springframework.beans.BeanUtils;

public class TarefaMapper {

    public static TarefaResponse mapToResponse(Tarefa tarefa) {
        TarefaResponse tarefaResponse = new TarefaResponse();
        BeanUtils.copyProperties(tarefa, tarefaResponse);
        return tarefaResponse;
    }

    public static Tarefa mapToTarefa(TarefaRequest tarefaRequest) {
        Tarefa tarefa = new Tarefa();
        BeanUtils.copyProperties(tarefaRequest, tarefa);
        return tarefa;
    }

}

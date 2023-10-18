package br.com.rafael.listatarefas.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaResponse {

    private Integer id;
    private String descricao;
    private boolean concluido;

}

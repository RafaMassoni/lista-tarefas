package br.com.rafael.listatarefas.model;


import lombok.*;

@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    private Integer id;
    private String descricao;
    private boolean concluido;

}

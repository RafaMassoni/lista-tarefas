package br.com.rafael.listatarefas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TarefaRequest {

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean concluido;

}

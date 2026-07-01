package com.dev.lxrd.AmanhaEuFaco.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaDto(
    @NotBlank
    String nome,
    @NotBlank
    String descricao,
    @NotNull
    boolean concluida
) {
    
}

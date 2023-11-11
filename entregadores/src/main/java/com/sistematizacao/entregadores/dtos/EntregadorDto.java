package com.sistematizacao.entregadores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregadorDto
		(@NotNull  Long   cpf, 
		 @NotBlank String nome, 
		 @NotNull  Double capacidadeVeiculo) {
}

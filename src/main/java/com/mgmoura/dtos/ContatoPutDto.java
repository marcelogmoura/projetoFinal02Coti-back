package com.mgmoura.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContatoPutDto {
	
	@NotNull(message = "Informe o ID")
	private Integer idContato;
	
	@NotBlank(message = "Preencha o NOME")
	private String nome;
	
	private String email;
	
	@NotBlank(message = "Preencha o TELEFONE")
	private String telefone;

}

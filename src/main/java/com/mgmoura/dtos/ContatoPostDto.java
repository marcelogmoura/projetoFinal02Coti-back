package com.mgmoura.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContatoPostDto {
	
	@Size(min = 3 , message = "Pelo menos 3 caracteres")
	@NotBlank(message = "Preencha o NOME")
	private String nome;
	
	@Email(message = "Informe um email válido")
	private String email;
	
	@NotBlank(message = "Preencha o TELEFONE")
	private String telefone;

}

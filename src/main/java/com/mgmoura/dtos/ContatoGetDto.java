package com.mgmoura.dtos;

import lombok.Data;

@Data
public class ContatoGetDto {
	
	private Integer idContato;
	private String nome;
	private String email;
	private String telefone;

}

package com.mgmoura.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_contato")
public class Contato {
	
	@Id
	@Column(name = "idContato")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContato;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 40, nullable = false, unique = true)
	private String email;
	
	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

}

package com.mgmoura.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgmoura.dtos.ContatoGetDto;
import com.mgmoura.dtos.ContatoPostDto;
import com.mgmoura.dtos.ContatoPutDto;
import com.mgmoura.repositories.ContatoRepository;
import com.mgmoura.services.ContatoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/contatos")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ContatoService contatoService;

	@PostMapping
	public ResponseEntity<ContatoGetDto> post(@RequestBody @Valid ContatoPostDto dto) {
		return contatoService.post(dto);
	}

	@PutMapping
	public ResponseEntity<ContatoGetDto> put(@RequestBody @Valid ContatoPutDto dto) {
		return contatoService.put(dto);
	}

	@DeleteMapping("{idContato}")
	public ResponseEntity<ContatoGetDto> delete(@PathVariable("idContato") Integer idContato) {
		return contatoService.delete(idContato);
	}

	@GetMapping
	public ResponseEntity<List<ContatoGetDto>> getAll() {
		return contatoService.getAll();
	}
	
	@GetMapping("/obterPorId/{idContato}")
	public ResponseEntity<ContatoGetDto> obterPorId(@PathVariable Integer idContato) {
		return contatoService.obterPorId(idContato);

	}

}

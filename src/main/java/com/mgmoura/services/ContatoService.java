package com.mgmoura.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mgmoura.dtos.ContatoGetDto;
import com.mgmoura.dtos.ContatoPostDto;
import com.mgmoura.dtos.ContatoPutDto;
import com.mgmoura.entities.Contato;
import com.mgmoura.repositories.ContatoRepository;

import jakarta.validation.Valid;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<ContatoGetDto> post(@RequestBody @Valid ContatoPostDto dto) {

	    if (contatoRepository.findByEmail(dto.getEmail().toLowerCase()) != null) {
	        throw new IllegalArgumentException("E-mail não disponível, utilize outro.");
	    }

	    Contato contato = modelMapper.map(dto, Contato.class);

	    String nome = dto.getNome();
	    
	    if (nome != null && !nome.isEmpty()) {
	        String[] partesNome = nome.split("\\s+");  // Dividir por espaços
	        StringBuilder nomeFormatado = new StringBuilder();

	        for (String parte : partesNome) {
	            if (!parte.isEmpty()) {
	                nomeFormatado.append(parte.substring(0, 1).toUpperCase()).append(parte.substring(1).toLowerCase()).append(" ");
	            }
	        }

	        nomeFormatado.setLength(nomeFormatado.length() - 1);

	        contato.setNome(nomeFormatado.toString());
	    }

	    contatoRepository.save(contato);

	    ContatoGetDto response = modelMapper.map(contato, ContatoGetDto.class);

	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}



	@PutMapping
	public ResponseEntity<ContatoGetDto> put(@RequestBody @Valid ContatoPutDto dto) {

	    Optional<Contato> consulta = contatoRepository.findById(dto.getIdContato());

	    if (consulta.isPresent()) {

	        Contato contato = consulta.get();

	        String nome = dto.getNome();
	        if (nome != null && !nome.isEmpty()) {
	            String[] partesNome = nome.split("\\s+");  // Dividir por espaços
	            StringBuilder nomeFormatado = new StringBuilder();

	            for (String parte : partesNome) {
	                if (!parte.isEmpty()) {
	                    nomeFormatado.append(parte.substring(0, 1).toUpperCase()).append(parte.substring(1).toLowerCase()).append(" ");
	                }
	            }

	            nomeFormatado.setLength(nomeFormatado.length() - 1);

	            contato.setNome(nomeFormatado.toString());
	        }

	        contato.setEmail(dto.getEmail());
	        contato.setTelefone(dto.getTelefone());

	        contatoRepository.save(contato);

	        ContatoGetDto response = modelMapper.map(contato, ContatoGetDto.class);

	        return ResponseEntity.status(HttpStatus.OK).body(response);

	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}


	@DeleteMapping("{idContato}")
	public ResponseEntity<ContatoGetDto> delete(@PathVariable("idContato") Integer idContato) {

		Optional<Contato> consulta = contatoRepository.findById(idContato);

		if (consulta.isPresent()) {

			Contato contato = consulta.get();

			contatoRepository.delete(contato);

			ContatoGetDto response = modelMapper.map(contato, ContatoGetDto.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping
	public ResponseEntity<List<ContatoGetDto>> getAll() {

		List<ContatoGetDto> lista = new ArrayList<ContatoGetDto>();

		for (Contato contato : contatoRepository.findAll()) {
			lista.add(modelMapper.map(contato, ContatoGetDto.class));
		}

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	

	@GetMapping("/obterPorId/{idContato}")
	public ResponseEntity<ContatoGetDto> obterPorId(@PathVariable Integer idContato) {

		Contato contato = contatoRepository.findByIdContato(idContato);

		if (contato != null) {
			ContatoGetDto dto = modelMapper.map(contato, ContatoGetDto.class);

			return ResponseEntity.ok(dto);

		} else {
			return null;
		}

	}
}

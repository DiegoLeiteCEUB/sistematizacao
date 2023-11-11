package com.sistematizacao.entregadores.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistematizacao.entregadores.dtos.EntregadorDto;
import com.sistematizacao.entregadores.models.EntregadoresModel;
import com.sistematizacao.entregadores.repositories.EntregadoresRepository;

import jakarta.validation.Valid;

@RestController
public class EntregadoresController {
	
	@Autowired
	EntregadoresRepository entregadoresRepository;
	
	@GetMapping("/entregadores")
	public ResponseEntity<List<EntregadoresModel>> listar() {
		List<EntregadoresModel> entregadoresList = entregadoresRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(entregadoresList);
	}
	
	@PostMapping("/entregadores")
	public ResponseEntity<EntregadoresModel> salvarEntregador(@RequestBody @Valid EntregadorDto entregadorDto) {
		var entregadoresModel = new EntregadoresModel();
		BeanUtils.copyProperties(entregadorDto, entregadoresModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(entregadoresRepository.save(entregadoresModel));
	}
	
	@GetMapping("/entregadores/{id}")
	public ResponseEntity<Object> detalharEntregador(@PathVariable(value="id") Integer id) {
		Optional<EntregadoresModel> entregador = entregadoresRepository.findById(id);
		if (entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não localizado para exibição.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(entregador.get());
	}

	@PutMapping("/entregadores/{id}")
	public ResponseEntity<Object> atualizarEntregador(@PathVariable(value="id") Integer id, 
			                                          @RequestBody @Valid EntregadorDto entregadorDto) {
		Optional<EntregadoresModel> entregador = entregadoresRepository.findById(id);
		if (entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não localizado para atualização.");
		}
		var entregadoresModel = entregador.get();
		BeanUtils.copyProperties(entregadorDto, entregadoresModel);
		return ResponseEntity.status(HttpStatus.OK).body(entregadoresRepository.save(entregadoresModel));
	}
	
	@DeleteMapping("/entregadores/{id}")
	public ResponseEntity<Object> excluirEntregador(@PathVariable(value="id") Integer id) {
		Optional<EntregadoresModel> entregador = entregadoresRepository.findById(id);
		if (entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não localizado para exclusão.");
		}
		entregadoresRepository.delete(entregador.get());
		return ResponseEntity.status(HttpStatus.OK).body("Entregador excluído com sucesso.");
	}
}
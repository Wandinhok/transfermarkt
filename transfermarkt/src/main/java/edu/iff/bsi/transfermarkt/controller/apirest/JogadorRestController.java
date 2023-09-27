package edu.iff.bsi.transfermarkt.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iff.bsi.transfermarkt.entities.Jogador;
import edu.iff.bsi.transfermarkt.repository.JogadorRepository;
import edu.iff.bsi.transfermarkt.service.JogadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/jogador", produces = "application/json")
@Tag(name = "Jogador", description = "API para gerenciar o CRUD de Jogador")
public class JogadorRestController {

	@Autowired
	private JogadorService service;

	@Autowired
	private JogadorRepository repository;

	@Operation(summary = "Buscar um usuário", description = "Obter um jogador por sua  'id'", tags = {
			"Jogador" })
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@Operation(summary = "Adicionando jogador", description = "Adicionando um novo jogador no banco", tags = {
			"Jogador" })
	@PostMapping
	public ResponseEntity save(@RequestBody Jogador jogador) {
		service.save(jogador);
		return ResponseEntity.status(HttpStatus.CREATED).body(jogador);
	}

	@Operation(summary = "Atualizar dados", description = "Atualiza as informações do jogador", tags = { "Jogador" })
	@PutMapping(value = "/{id}")
	public ResponseEntity alterar(@RequestBody Jogador jogador) {
		repository.save(jogador);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Operation(summary = "Deletando", description = "Excluir um usuário pelo id", tags = { "Jogador" })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.iff.bsi.transfermarkt.entities.User;
import edu.iff.bsi.transfermarkt.repository.UserRepository;
import edu.iff.bsi.transfermarkt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

 

@RestController

@RequestMapping(path = "/api/user", produces = "application/json")

@Tag(name = "User", description = "API para gerenciar o CRUD de Usuario")

public class UserRestController {

 

    @Autowired

    private UserService service;

 

    @Autowired

    private UserRepository repository;

 

    @Operation(summary = "Obter uma lista de usuários ", description = "Obter uma lista de usuários do time Transfermarkt", tags = {

            "User" })

    @GetMapping()

    public ResponseEntity getAll() {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

        } catch (Exception error) {

            return ResponseEntity.status(500).body(error.getMessage());

        }

    }

 

    @Operation(summary = "Buscar um user", description = "Buscar um usuário por seu nome", tags = {

            "User" })

    @GetMapping(value = "/{id}")

    public ResponseEntity getOne(@RequestParam("id") Long id) {

        try {

            return ResponseEntity.ok(service.findById(id));

        } catch (Exception error) {

            return ResponseEntity.status(500).body(error.getMessage());

        }

    }

 

    @Operation(summary = "Adicionando user", description = "Adicionando um novo jogador no banco", tags = { "User" })

    @PostMapping

    public ResponseEntity save(@RequestBody User user) {

        service.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

 

    @Operation(summary = "Atualizar dados", description = "Atualiza as informações do usuário", tags = { "User" })

    @PutMapping(value = "/{id}")

    public ResponseEntity alterar(@RequestBody User user) {

        repository.save(user);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

 

    @Operation(summary = "Deletando", description = "Excluir um usuário pelo id", tags = { "User" })

    @DeleteMapping(value = "/{id}")

    public ResponseEntity delete(@PathVariable("id") Long id) {

        service.delete(id);

        return ResponseEntity.ok().build();

    }

 

}
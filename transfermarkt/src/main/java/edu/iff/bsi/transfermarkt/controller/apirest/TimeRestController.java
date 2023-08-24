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

import edu.iff.bsi.transfermarkt.entities.Time;
import edu.iff.bsi.transfermarkt.repository.TimeRepository;
import edu.iff.bsi.transfermarkt.service.TimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/time")
@Tag(name = "Time", description = "API para gerenciar o CRUD de Time")

public class TimeRestController {

 

    @Autowired
    private TimeService service;


       @Autowired

    private TimeRepository repository;

   

    @Operation(summary = "Obter uma lista de jogadores do time ", description = "Obter uma lista de jogadores do time Transfermarkt", tags = {

            "Time" })

    @GetMapping()

    public ResponseEntity getAll() {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

        } catch (Exception error) {

            return ResponseEntity.status(500).body(error.getMessage());

        }

    }

 

    @Operation(summary = "Adicionando Time", description = "Adicionando um novo time no transfermarkt", tags = {
            "Time" })

    @PostMapping
    public ResponseEntity save(@RequestBody Time time) {

        service.save(time);

        return ResponseEntity.status(HttpStatus.CREATED).body(time);

    }

 

    @Operation(summary = "Atualizar dados", description = "Atualiza as informações do time", tags = { "Time" })
    @PutMapping(value = "/{id}")
    public ResponseEntity alterar(@RequestBody Time time) {

        repository.save(time);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

 

    @Operation(summary = "Apagando time", description = "Excluir um time pelo id", tags = { "Time" })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        service.delete(id);

        return ResponseEntity.ok().build();

    }
}
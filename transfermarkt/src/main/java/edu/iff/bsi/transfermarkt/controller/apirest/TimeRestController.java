package edu.iff.bsi.transfermarkt.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iff.bsi.transfermarkt.service.TimeService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api")
public class TimeRestController {

 

    @Autowired
    private TimeService service;

      @Operation(summary = "Obter uma lista de jogadores ", description = "Obter uma lista de jogadores no Transfermarkt", tags = {"Time" })
      @GetMapping(value = "/Times")

      public ResponseEntity getAll() {
            try {
                  return ResponseEntity.ok(service.findAll());
            } catch (Exception error) {
                  return ResponseEntity.status(500).body(error.getMessage());
            }
      }
        @Operation(summary = "Deletando", description = "Excluir um time pelo seu id", tags = { "Jogador" })
        @DeleteMapping(value = "/time/{id}")
         public ResponseEntity <?> delete(@PathVariable("id") Long id) {
                        service.delete(id);
                        return ResponseEntity.ok().build();

      }
}
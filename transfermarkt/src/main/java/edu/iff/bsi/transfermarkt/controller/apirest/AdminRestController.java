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

import edu.iff.bsi.transfermarkt.entities.Admin;
import edu.iff.bsi.transfermarkt.repository.AdminRepository;
import edu.iff.bsi.transfermarkt.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/admin", produces = "application/json")
@Tag(name = "Admin", description = "API para gerenciar o CRUD de Admin")
public class AdminRestController {

    @Autowired
    private AdminService service;

    @Autowired
    private AdminRepository repository;

    @Operation(summary = "Obter uma lista de adms ", description = "Obter uma lista de adms do time Transfermarkt", tags = {
            "Admin" })
    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception error) {
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }

    @Operation(summary = "Buscar um Adm", description = "Buscar um adm por sua id", tags = {
            "Admin" })
    @GetMapping(value = "/{id}")
    public ResponseEntity getOne(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception error) {
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }

    @Operation(summary = "Adicionando user", description = "Adicionando um novo adm no banco", tags = { "Admin" })
    @PostMapping
    public ResponseEntity save(@RequestBody Admin admin) {
        service.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @Operation(summary = "Atualizar dados", description = "Atualiza as informações do Admin", tags = { "Admin" })
    @PutMapping(value = "/{id}")
    public ResponseEntity alterar(@RequestBody Admin admin) {
        repository.save(admin);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Deletando", description = "Excluir um Admin pelo id", tags = { "Admin" })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}


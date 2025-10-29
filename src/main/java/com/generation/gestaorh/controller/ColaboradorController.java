package com.generation.gestaorh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gestaorh.model.Colaborador;
import com.generation.gestaorh.repository.ColaboradorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    // GET all
    @GetMapping("/all")
    public ResponseEntity<List<Colaborador>> getAll() {
        return ResponseEntity.ok(colaboradorRepository.findAll());
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> getById(@PathVariable Long id) {
        return colaboradorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST
    @PostMapping("/cadastrar")
    public ResponseEntity<Colaborador> post(@Valid @RequestBody Colaborador colaborador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorRepository.save(colaborador));
    }

    // PUT
    @PutMapping("/atualizar")
    public ResponseEntity<Colaborador> put(@Valid @RequestBody Colaborador colaborador) {
        return colaboradorRepository.findById(colaborador.getId())
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.save(colaborador)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        colaboradorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

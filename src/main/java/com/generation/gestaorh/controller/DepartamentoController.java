package com.generation.gestaorh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.gestaorh.model.Departamento;
import com.generation.gestaorh.repository.DepartamentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    // Listar todos os departamentos
    @GetMapping("/all")
    public ResponseEntity<List<Departamento>> getAll() {
        return ResponseEntity.ok(departamentoRepository.findAll());
    }

    // Buscar departamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getById(@PathVariable Long id) {
        return departamentoRepository.findById(id)
                .map(depto -> ResponseEntity.ok(depto))
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar novo departamento
    @PostMapping("/cadastrar")
    public ResponseEntity<Departamento> postDepartamento(@Valid @RequestBody Departamento departamento) {
        departamento.setId(null); // garante que é novo registro
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoRepository.save(departamento));
    }

    // Atualizar departamento existente
    @PutMapping("/atualizar")
    public ResponseEntity<Departamento> putDepartamento(@Valid @RequestBody Departamento departamento) {
        return departamentoRepository.findById(departamento.getId())
                .map(depto -> ResponseEntity.ok(departamentoRepository.save(departamento)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar departamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartamento(@PathVariable Long id) {
        return departamentoRepository.findById(id)
                .map(depto -> {
                    departamentoRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

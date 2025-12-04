package com.generation.gestaorh.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gestaorh.model.Colaborador;
import com.generation.gestaorh.record.CalculoSalario;
import com.generation.gestaorh.record.Holerite;
import com.generation.gestaorh.service.CalcularSalarioService;
import com.generation.gestaorh.service.ColaboradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(
	    origins = {"http://localhost:5173/", "https://gestaorh-529f.onrender.com/"},
	    allowedHeaders = "*"
	)
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private CalcularSalarioService calcularSalarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Colaborador>> getAll() {
		return ResponseEntity.ok(colaboradorService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> getById(@PathVariable Long id) {
		return colaboradorService.getById(id);
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Colaborador> post(@Valid @RequestBody Colaborador colaborador) {
		return colaboradorService.post(colaborador);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Colaborador> put(@Valid @RequestBody Colaborador colaborador) {
		return colaboradorService.put(colaborador);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		colaboradorService.delete(id);
	}

	@PostMapping("/calcularsalario/{id}")
	public ResponseEntity<Holerite> calcularSalario(
			@PathVariable Long id,
			@RequestBody CalculoSalario dadosSalario) {

		Holerite holerite = calcularSalarioService.calcularSalario(id, dadosSalario);
		return ResponseEntity.status(HttpStatus.OK).body(holerite);
	}
}
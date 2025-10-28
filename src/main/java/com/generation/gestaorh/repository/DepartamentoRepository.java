package com.generation.gestaorh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.gestaorh.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    // Buscar departamentos pelo nome, ignorando maiúsculas/minúsculas
    public List<Departamento> findAllByNomeContainingIgnoreCase(String nome);

}

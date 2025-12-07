package com.generation.gestaorh.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do departamento é obrigatório!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("departamento") // evita loop ao serializar
    private List<Colaborador> colaboradores = new ArrayList<>();

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Colaborador> getColaboradores() { return colaboradores; }
    public void setColaboradores(List<Colaborador> colaboradores) { this.colaboradores = colaboradores; }
}

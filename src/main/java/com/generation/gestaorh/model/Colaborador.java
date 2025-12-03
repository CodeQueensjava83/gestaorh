package com.generation.gestaorh.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tb_colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O cargo é obrigatório")
    private String cargo;

    @NotBlank(message = "O setor é obrigatório")
    private String setor;

    @NotNull(message = "O salário é obrigatório")
    @Positive(message = "O Salário deve ser um valor positivo")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal salario;

    @NotNull(message = "O número de Horas Mensais é obrigatório!")
    @Positive(message = "O número de Horas Mensais deve ser um número positivo")
    private Integer horasMensais;

    @NotNull(message = "O Número de Dependentes é obrigatório!")
    @PositiveOrZero(message = "O número de Dependentes deve ser um número positivo ou zero")
    private Integer dependentes = 0;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    @JsonIgnoreProperties("colaboradores") // evita loop ao serializar
    private Departamento departamento;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }

    public Integer getHorasMensais() { return horasMensais; }
    public void setHorasMensais(Integer horasMensais) { this.horasMensais = horasMensais; }

    public Integer getDependentes() { return dependentes; }
    public void setDependentes(Integer dependentes) { this.dependentes = dependentes; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}

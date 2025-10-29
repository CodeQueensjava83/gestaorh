package com.generation.gestaorh.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

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
    @Column(precision = 10, scale = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "R$ #,##0.00")
    private BigDecimal salario;
    
    @Column(precision = 6, scale = 2)
    private int horasMensais;
    
    @Column(precision = 10, scale = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "R$ #,##0.00")
    private BigDecimal bonus;
    
    @Column(precision = 10, scale = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "R$ #,##0.00")
    private BigDecimal descontos;
    
    @Min(value = 0, message = "O Número de Dependentes deve ser um numero positivo ou zero")
	@NotNull(message = "O Número de Dependentes é obrigatório!")
	@PositiveOrZero(message = "O número de Dependentes deve ser um numero positivo ou zero")
	private int dependentes = 0;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    @JsonIgnoreProperties("colaborador")
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

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public int getDependentes() {
		return dependentes;
	}
	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}
	
	public int getHorasMensais() {
		return horasMensais;
	}
	public void setHorasMensais(int horasMensais) {
		this.horasMensais = horasMensais;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	public BigDecimal getDescontos() {
		return descontos;
	}
	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}
    
	
    
}

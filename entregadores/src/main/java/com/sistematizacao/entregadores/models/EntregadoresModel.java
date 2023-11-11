package com.sistematizacao.entregadores.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTREGADORES")
public class EntregadoresModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Long cpf;
	private String nome;
	private Double capacidadeVeiculo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getCapacidadeVeiculo() {
		return capacidadeVeiculo;
	}
	public void setCapacidadeVeiculo(Double capacidadeVeiculo) {
		this.capacidadeVeiculo = capacidadeVeiculo;
	}
}

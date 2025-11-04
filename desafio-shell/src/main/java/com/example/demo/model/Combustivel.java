package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "combustiveis")
public class Combustivel {
	
	@Id
	@Column(name = "tipo_combustivel")	
	private String nome;
	
	@Column(name = "preco_litro")
	private Double precoLitro;
	
//	Relacionando combustivel pode estar em diversas bombas
	@OneToMany(mappedBy = "combustivel")
	private List<BombasCombustivel> bombas;
}

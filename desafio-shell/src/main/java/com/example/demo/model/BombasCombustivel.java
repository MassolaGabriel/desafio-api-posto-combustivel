package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class BombasCombustivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_da_bomba", unique = true)
	private String nomeDaBomba;
	
	@ManyToOne
	@JoinColumn(name = "tipo_combustivel_nome")
	private Combustivel combustivel;
	
	@OneToMany(mappedBy = "bombasCombustivel")
	private List<Abastecimentos> abastecimentos;
}

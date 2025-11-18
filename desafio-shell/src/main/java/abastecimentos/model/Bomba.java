package abastecimentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bombas")
public class Bomba {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "combustivel_id", nullable = false)
	private Combustivel combustivel;
}
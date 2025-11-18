package abastecimentos.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "abastecimentos")
public class Abastecimentos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_abastecimento")
	@Past
	private LocalDate dataAbastecimento;
	
	@Column(name = "volume_abastecido")
	private Double volumeAbastecido;
	
	@Column(name = "valor_total")
	private Double valorTotal;

	@JsonBackReference(value = "bomba-abastecimento")
	@ManyToOne
	@JoinColumn(name = "bomba_id")
	private BombasCombustivel bombasCombustivel;
}

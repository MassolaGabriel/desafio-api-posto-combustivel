package abastecimentos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime; // Melhor que LocalDate para saber a hora exata

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "abastecimentos")
public class Abastecimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_hora", nullable = false)
	private LocalDateTime dataHora; // Data E Hora são importantes em posto

	@Column(name = "volume_litros", nullable = false)
	private BigDecimal volumeLitros;

	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "bomba_id", nullable = false)
	private Bomba bomba;
}
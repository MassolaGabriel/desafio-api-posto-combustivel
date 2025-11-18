package abastecimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import abastecimentos.model.Abastecimento;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer>{

}

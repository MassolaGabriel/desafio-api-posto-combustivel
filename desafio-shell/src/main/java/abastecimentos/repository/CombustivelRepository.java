package abastecimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import abastecimentos.model.Combustivel;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, String>{

}

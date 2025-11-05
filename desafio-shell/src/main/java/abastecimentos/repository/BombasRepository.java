package abastecimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import abastecimentos.model.BombasCombustivel;

@Repository
public interface BombasRepository extends JpaRepository<BombasCombustivel, Integer>{

}

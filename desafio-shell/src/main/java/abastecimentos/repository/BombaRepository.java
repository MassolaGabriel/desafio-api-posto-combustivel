package abastecimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import abastecimentos.model.Bomba;

@Repository
public interface BombaRepository extends JpaRepository<Bomba, Integer>{

}

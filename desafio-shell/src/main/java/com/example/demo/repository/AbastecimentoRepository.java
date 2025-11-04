package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Abastecimentos;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimentos, Integer>{

}

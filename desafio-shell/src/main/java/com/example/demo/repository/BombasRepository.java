package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BombasCombustivel;

@Repository
public interface BombasRepository extends JpaRepository<BombasCombustivel, Integer>{

}

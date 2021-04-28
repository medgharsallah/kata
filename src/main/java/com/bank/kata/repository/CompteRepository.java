package com.bank.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.kata.domain.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	Compte findByRib(String rib);

}

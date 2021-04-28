package com.bank.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.kata.domain.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}

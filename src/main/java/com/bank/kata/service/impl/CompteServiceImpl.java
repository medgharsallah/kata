package com.bank.kata.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.kata.domain.Compte;
import com.bank.kata.domain.Operation;
import com.bank.kata.domain.enumeration.TypeOperation;
import com.bank.kata.repository.CompteRepository;
import com.bank.kata.repository.OperationRepository;
import com.bank.kata.service.CompteService;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	OperationRepository operationRepository;

	@Override
	public void depositToAccount(String rib, double amount) {
		
		Compte compte = compteRepository.findByRib(rib);
		
		double newBalance = compte.getAmount() + amount;
		List<Operation> operations = new ArrayList<>();
		Operation operation = new Operation(TypeOperation.DEPOSIT, LocalDateTime.now(), amount, newBalance, compte);
		operations.add(operation);

		compte.setOperations(operations);
		compte.setAmount(newBalance);
		compteRepository.save(compte);
	}

	@Override
	public void withdrawalFromAccount(String rib, double amount) {
		
		Compte compte = compteRepository.findByRib(rib);
		
		if(compte.getAmount() < amount) throw new RuntimeException("Insufficient Balance");
		
		double newBalance = compte.getAmount() - amount;
		List<Operation> operations = new ArrayList<>();
		Operation operation = new Operation(TypeOperation.WITHDRAWAL, LocalDateTime.now(), amount, newBalance, compte);
		operations.add(operation);

		compte.setOperations(operations);
		compte.setAmount(newBalance);
		compteRepository.save(compte);
		
	}

}

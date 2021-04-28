package com.bank.kata.service;

import java.util.List;

import com.bank.kata.domain.Operation;

public interface OperationService {
	
	List<Operation> findOperations(String rib);

}

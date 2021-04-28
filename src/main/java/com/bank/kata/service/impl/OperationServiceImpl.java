package com.bank.kata.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.kata.domain.Operation;
import com.bank.kata.repository.OperationRepository;
import com.bank.kata.service.OperationService;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {
	
	@Autowired
	OperationRepository operationRepository;

	@Override
	public List<Operation> findOperations(String rib) {
		return operationRepository.findOperationsByRib(rib);
	}

}

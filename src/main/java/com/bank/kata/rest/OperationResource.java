package com.bank.kata.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.kata.domain.Operation;
import com.bank.kata.service.OperationService;

@RestController
@RequestMapping("/api/operation") 
public class OperationResource {
	
	@Autowired
	OperationService operationService;
	
	/*
	 * pour la partie de la génération de l'historique des opérations, je peux le faire avec jasper report
	 * mais à cause du temps, j'ai implémenté un service pour retourner la liste des opérations
	 * 
	 * */
	@GetMapping("/historique")
	public ResponseEntity<?> getHistoriques(@RequestParam("rib") String rib)
			throws Exception {
		
		List<Operation> operations = operationService.findOperations(rib);
		
		return new ResponseEntity<>(operations, HttpStatus.OK);
		
	}

}

package com.bank.kata.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.kata.service.CompteService;

@RestController
@RequestMapping("/api/compte") 
public class CompteResource {
	
	@Autowired
	CompteService compteService;
	
	@PutMapping("/deposit")
	public ResponseEntity<?> depositToAccount(@RequestParam("rib") String rib, @RequestParam("amount") double amount) 
			throws Exception {
		
		compteService.depositToAccount(rib, amount);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/withdrawal")
	public ResponseEntity<?> withdrawalFromAccount(@RequestParam("rib") String rib, @RequestParam("amount") double amount) 
			throws Exception {
		
		compteService.withdrawalFromAccount(rib, amount);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

package com.bank.kata.service;

public interface CompteService {
	
	void depositToAccount(String rib, double amount);
	
	void withdrawalFromAccount(String rib, double amount);

}

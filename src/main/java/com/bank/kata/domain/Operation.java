package com.bank.kata.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bank.kata.domain.enumeration.TypeOperation;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "operation")
public class Operation implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	@Column(name = "type_operation")
	private TypeOperation typeOperation;
	
	@Column(name = "date_operation")
	private LocalDateTime dateOperation;
	
	@Column(name = "montant")
	private double amount;
	
	@Column(name = "balance")
	private double balance;
	
	@ManyToOne
    @JoinColumn(name = "compte_id")
    @JsonBackReference
	private Compte compte;

	public Operation(TypeOperation typeOperation, LocalDateTime dateOperation, double amount, double balance,
			Compte compte) {
		this.typeOperation = typeOperation;
		this.dateOperation = dateOperation;
		this.amount = amount;
		this.balance = balance;
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(TypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public LocalDateTime getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(LocalDateTime dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", typeOperation=" + typeOperation + ", dateOperation=" + dateOperation
				+ ", amount=" + amount + ", balance=" + balance + ", compte=" + compte + "]";
	}

	

}

package com.bank.kata.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "compte")
public class Compte implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	@Column(name = "rib")
	private String rib;
	
	@Column(name = "date_creation")
	private LocalDateTime dateCreation;
	
	@Column(name = "amount")
	private double amount;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
	private Client client;
	
	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Operation> operations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", rib=" + rib + ", dateCreation=" + dateCreation + ", amount=" + amount
				+ ", client=" + client + ", operations=" + operations + "]";
	}
	
}

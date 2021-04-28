package com.bank.kata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.kata.domain.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	@Query("select op from Operation op where op.compte.rib =:rib")
    List<Operation> findOperationsByRib(@Param("rib") String rib);

}

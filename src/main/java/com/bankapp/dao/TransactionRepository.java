package com.bankapp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {


	@Query(value = "SELECT * FROM transaction t WHERE t.sender_id = :id or t.receiver_id =:id order by created_time_stamp; " , nativeQuery=true )
	List<Transaction> listAllTransaction(@Param("id")Long id);
	
}

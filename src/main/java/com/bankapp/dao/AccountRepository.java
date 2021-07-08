package com.bankapp.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bankapp.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{


	Optional<Account> findById(Long id);
}

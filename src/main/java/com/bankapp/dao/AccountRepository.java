package com.bankapp.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bankapp.model.Account;

@RepositoryRestResource(collectionResourceRel = "account", path = "account")
//@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{


	Optional<Account> findById(Long id);
}

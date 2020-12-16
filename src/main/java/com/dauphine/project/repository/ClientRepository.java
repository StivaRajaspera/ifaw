package com.dauphine.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dauphine.project.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
	public Client findByEmail(String email);	

}
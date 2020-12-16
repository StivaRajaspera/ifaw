package com.dauphine.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dauphine.project.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    public User findByUsername(String username); 
    public  User findByEmail(String email);
    

    
}
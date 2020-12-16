package com.dauphine.project.repository;


import com.dauphine.project.entity.DemandeDevis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends CrudRepository<DemandeDevis, Long> {
   // public DemandeDevis findByEmail(String email);
}

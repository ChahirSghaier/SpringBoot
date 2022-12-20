package com.example.springboot.repository;

import com.example.springboot.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ContratRepo extends JpaRepository<Contrat,Integer> {
    @Query("select c from Contrat c where c.id=?1 ")
    Contrat findContratById(Integer id);
    @Query("select c from Contrat c where c.id=?1 ")
    Set<Contrat> findContratsById(Integer id);
}

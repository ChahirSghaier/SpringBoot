package com.example.springboot.repository;

import com.example.springboot.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UniversityRepo extends JpaRepository<Universite,Integer> {
    @Modifying
    @Transactional
    @Query("update Universite u set u.id=?1,u.departement=?2,u.nomUniv=?3")
    Universite update(Universite u);
    @Query("select  u from Universite u where u.id=?1")
     Universite findUniversiteById(Integer idUniversite);
}

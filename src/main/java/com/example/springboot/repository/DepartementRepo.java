package com.example.springboot.repository;

import com.example.springboot.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepo extends JpaRepository<Departement,Integer> {
@Query("update Departement d set d.id=?1,d.nomDepart=?2 ")
    Departement update(Departement d);
@Query("select d from Departement d where d.id=:idDepart")
    Departement findDepartementById(Integer idDepart);
}

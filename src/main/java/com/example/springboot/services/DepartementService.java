package com.example.springboot.services;

import com.example.springboot.entities.Departement;
import com.example.springboot.entities.Universite;
import com.example.springboot.repository.DepartementRepo;
import com.example.springboot.repository.UniversityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DepartementService implements IDepartementService{
    DepartementRepo departementRepo;
    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> departements ;
        departements = departementRepo.findAll();
        return departements;
    }

    @Override
    public Departement addDepartement(Departement d) {
        Departement departement= departementRepo.save(d);
        return departement;
    }

    @Override
    public Departement updateDepartement(Departement d) {
      Departement departement = departementRepo.update(d);
        return departement;
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepo.findDepartementById(idDepart) ;
    }

    /**
     * @apiNote  Ici j'ai cherché l'université en premier lieu par son identifiant
     * pour avoir la liste de départements en ce dernier
     *
     */

    UniversityRepo universityRepo;
    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universityRepo.findUniversiteById(idUniversite);
        Set<Departement> departments = universite.getDepartement();
        List<Departement> departmentsList ;
        departmentsList= new ArrayList<>(departments);
        return departmentsList;
    }
}

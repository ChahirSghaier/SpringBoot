package com.example.springboot.services;

import com.example.springboot.entities.Departement;
import com.example.springboot.entities.Universite;
import com.example.springboot.repository.DepartementRepo;
import com.example.springboot.repository.UniversityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@AllArgsConstructor
@Service
public class UniversityService implements IUniversityService {
UniversityRepo universityRepo;
    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universities;
        universities = universityRepo.findAll();
        return universities;
    }

    @Override
    public Universite addUniversite(Universite u) {
   Universite university = universityRepo.save(u);
   return university;
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universityRepo.update(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        Universite u = universityRepo.findUniversiteById(idUniversite);
        return u;
    }

    DepartementRepo departementRepo;
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite university = universityRepo.findUniversiteById(idUniversite);
        Departement departement =  departementRepo.findDepartementById(idDepartement);
        university.add(departement);
        universityRepo.save(university);
    }

}

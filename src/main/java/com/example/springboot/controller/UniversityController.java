package com.example.springboot.controller;

import com.example.springboot.entities.Departement;
import com.example.springboot.entities.Universite;
import com.example.springboot.services.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/university")
public class UniversityController {
    IUniversityService universityService;

    @GetMapping("/retrieve-all-universities")
    public List<Universite> getAllDepartment(){
        List<Universite> contrats;
        contrats=universityService.retrieveAllUniversites();
        return contrats;
    }

    @PutMapping("/update")
    public Universite updateDepartment(@RequestBody Universite c){
        Universite contrat;
        contrat=universityService.updateUniversite(c);
        return contrat;
    }

    @PostMapping("/add-university")
    public Universite addUniversity(@RequestBody Universite c){
        return universityService.addUniversite(c);
    }

    @GetMapping("/retrieve-university/{id}")
    public Universite findDepartmentById(@PathVariable(value="id") Integer id){
        return universityService.retrieveUniversite(id);
    }

 @PutMapping("/assignUniversityToDepartment/{id}/{idDep}")
 public void assignUniversiteToDepartement(@PathVariable(value="id")Integer idUniversite, @PathVariable(value="idDep")Integer idDepartement) {
      universityService.assignUniversiteToDepartement(idUniversite, idDepartement);
    }

 }

package com.example.springboot.controller;

import com.example.springboot.entities.Contrat;
import com.example.springboot.entities.Departement;
import com.example.springboot.services.IDepartementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {
    IDepartementService departementService;
    @GetMapping("/retrieve-all-departments")
    public List<Departement> getAllDepartment(){
        List<Departement> contrats;
        contrats=departementService.retrieveAllDepartements();
        return contrats;
    }
    @PutMapping("/update-department")
    public Departement updateDepartment(@RequestBody Departement c){
        Departement contrat;
        contrat=departementService.updateDepartement(c);
        return contrat;
    }
    @PostMapping("/add-department")
    public Departement addDepartment(@RequestBody Departement c){
        return departementService.addDepartement(c);
    }
    @GetMapping("/retrieve-department/{id}")
    public Departement findDepartmentById(@PathVariable(value="id") Integer id){
        return departementService.retrieveDepartement(id);
    }

    @GetMapping("/retrieve-department-by-university/{id}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable(value="id")Integer idUniversite){
        return departementService.retrieveDepartementsByUniversite(idUniversite);
    }
}

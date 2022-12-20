package com.example.springboot.controller;

import com.example.springboot.entities.Etudiant;
import com.example.springboot.entities.Team;
import com.example.springboot.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class EtudiantController {
   private IEtudiantService etudiantService;
    @GetMapping("/retrieve-all-students")
    public List<Etudiant> getEquipes()
    {
        List<Etudiant> etudiantList ;
        etudiantList= etudiantService.retrieveAllEquipes();
        return etudiantList;
    }
    // http://localhost:8082/chahir/student/retrieve-student/1
    @GetMapping("/retrieve-student/{id}")
    public Etudiant retrieveTeam(@PathVariable("id") Integer teamId) {
        Etudiant etudiant;
        etudiant = etudiantService.retrieveEtudiant(teamId);
        return etudiant;
    }

    // http://localhost:8082/chahir/student/add-student
    @PostMapping("/add-student")
    public Etudiant addTeam(@RequestBody Etudiant team) {

        Etudiant etudiant = etudiantService.addEtudiant(team);
        return etudiant;
    }

    // http://localhost:8082/chahir/student/remove-student/1
    @DeleteMapping("/remove-student/{id}")
    public void removeTeam(@PathVariable("id") Integer TeamId)
    {
        etudiantService.removeEtudiant(TeamId);
    }

    // http://localhost:8082/chahir/student/update-student/
    @PutMapping("/update-student")
    public Etudiant updateEtudiant(@RequestBody Etudiant team ) {
        return etudiantService.updateEtudiant(team);
    }
    // http://localhost:8082/chahir/student/assign-student-contract-team//
    @PutMapping("/assign-student-contract-team/{idContrat}/{idTeam}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant student , @PathVariable ("idContrat")Integer idContrat ,@PathVariable("idTeam") Integer idTeam)
    {
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(student,idContrat,idTeam);
    }
    // http://localhost:8082/chahir/student/get-student-by-department/
    @GetMapping("/get-student-by-department/{idDepartment}")
    public List<Etudiant>  getEtudiantsByDepartement(@PathVariable(value="idDepartment")Integer idDepartment){
        return etudiantService.getEtudiantsByDepartement(idDepartment);
    }
    //http://localhost:8082/chahir/student/assign-student-department//
    @PutMapping("/assign-student-department/{idEtudiant}/{idDepartment}")
    public Etudiant assignEtudiantToDepartment( @PathVariable ("idEtudiant")Integer idEtudiant ,@PathVariable("idDepartment") Integer idDepartment)
    {
      return   etudiantService.assignEtudiantToDepartement(idEtudiant,idDepartment);
    }
}

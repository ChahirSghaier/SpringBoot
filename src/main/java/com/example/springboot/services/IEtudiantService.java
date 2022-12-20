package com.example.springboot.services;

import com.example.springboot.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
     List<Etudiant> retrieveAllEquipes();
    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);

     Etudiant assignEtudiantToDepartement (Integer etudiantId, Integer
            departementId) ;
    void removeEtudiant(Integer idEtudiant);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat , Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}

package com.example.springboot.services;

import com.example.springboot.entities.Contrat;
import com.example.springboot.entities.Departement;
import com.example.springboot.entities.Etudiant;
import com.example.springboot.entities.Team;
import com.example.springboot.repository.ContratRepo;
import com.example.springboot.repository.DepartementRepo;
import com.example.springboot.repository.EtudiantRepos;
import com.example.springboot.repository.TeamRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {
EtudiantRepos etudiantRepos ;
    @Override
    public List<Etudiant> retrieveAllEquipes() {
        List<Etudiant> students;
        students= etudiantRepos.findAll();
        return students;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        Etudiant etudiant = etudiantRepos.save(e);
        return etudiant;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
       Etudiant etudiant = etudiantRepos.findEtudiantById(e.getId());
       etudiant.setNom(e.getNom());
       etudiant.setPrenom(e.getPrenom());
       etudiant.setOptions(e.getOptions());
       etudiant.setDepartement(e.getDepartement());
       etudiant.setContrats(e.getContrats());
       etudiant.setEquipes(e.getEquipes());
       Etudiant et =  etudiantRepos.save(etudiant);
        return et;
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepos.findEtudiantById(idEtudiant);
    }

    DepartementRepo departementRepo;

    @Override
    public Etudiant assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Departement departement = departementRepo.findDepartementById(departementId);
        Etudiant etudiant =etudiantRepos.findEtudiantById(etudiantId);
        etudiant.setDepartement(departement);
       /* departement.addEtudiant(etudiant);
        departementRepo.save(departement);*/
      return  etudiantRepos.save(etudiant);

    }

    @Override
    public void removeEtudiant(Integer idEtudiant)
    {
   etudiantRepos.delete(idEtudiant);
    }

    ContratRepo contratRepo;
    TeamRepo teamRepo;

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe)
    {
       Set<Contrat> contrats ;
       contrats=contratRepo.findContratsById(idContrat);
       Set<Team> teams;
       teams = teamRepo.findTeamsById(Long.valueOf(idEquipe));
        e.setContrats(contrats);
        e.setEquipes(teams);
        return etudiantRepos.save(e);
    }
    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement departement = departementRepo.findDepartementById(idDepartement);
        Set<Etudiant> students = departement.getEtudiants();
        return new ArrayList<>(students);
    }


}

package com.example.springboot.services;

import com.example.springboot.entities.Contrat;
import com.example.springboot.entities.Etudiant;
import com.example.springboot.repository.ContratRepo;
import com.example.springboot.repository.EtudiantRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ContratService implements IContratService {
    ContratRepo contratRepo;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats;
        contrats = contratRepo.findAll();
        return contrats;
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        Contrat contract = contratRepo.findContratById(ce.getId());
        contract.setArchive(ce.getArchive());
        contract.setDateDebutContrat(ce.getDateDebutContrat());
        contract.setDateFinContrat(ce.getDateFinContrat());
        contract.setMontantContrat(ce.getMontantContrat());
        contract.setSpecialites(ce.getSpecialites());
        contract.setEtudiant(ce.getEtudiant());
        contratRepo.save(contract);

        return contract;
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        Contrat contrat;
        contrat = contratRepo.save(ce);
        return contrat;
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepo.findContratById(idContrat);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepo.deleteById(idContrat);
    }

    EtudiantRepos etudiantRepos;
    @Override
    public Contrat affectContratToEtudiant(Integer idContrat, String nomE, String prenomE) {
        Contrat contrat = retrieveContrat(idContrat);
        Etudiant student = etudiantRepos.findEtudiantByNomAndPrenom(nomE, prenomE);
        if ((long) student.getContrats().size() < 5) {
            contrat.setEtudiant(student);
        }
        return contratRepo.save(contrat);
    }


}

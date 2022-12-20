package com.example.springboot.services;

import com.example.springboot.entities.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Contrat affectContratToEtudiant (Integer idContrat,String nomE,String prenomE );
}

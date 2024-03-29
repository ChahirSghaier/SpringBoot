package com.example.springboot.services;

import com.example.springboot.entities.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);


    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}

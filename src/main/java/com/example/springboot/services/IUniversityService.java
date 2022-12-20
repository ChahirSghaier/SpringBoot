package com.example.springboot.services;

import com.example.springboot.entities.Universite;

import java.util.List;

public interface IUniversityService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
     void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);
}

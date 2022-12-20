package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_contract")
/**
 * constructeur qui accepte tous les instances variables
 */
@AllArgsConstructor
/**
 * constructeur par défaut
 */
@NoArgsConstructor
/**
 * à la place du fonction get(){}
 * c'est pour avoir nos instances variables puisqu'ils sont private gràce à l'encapsulation
 */
@Getter
/**
 * à la place du fonction void set(){}
 * et ceci pour affecter une variable litérale au nos "objects fields"
 */
@Setter
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    /**
     * Temporal permet de gérer la date debut sous cette forme 17-10-2022
     */
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialites;
    private Boolean archive;
    private Integer montantContrat;
    @ManyToOne(fetch = FetchType.LAZY)
    private Etudiant etudiant;
}

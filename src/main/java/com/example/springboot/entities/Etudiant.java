package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="t_student")
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
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
   private String nom;
   private String prenom;
   @Enumerated(EnumType.STRING)
   private Option options;
   @ManyToOne(fetch = FetchType.LAZY)
    private Departement departement;
   @OneToMany(targetEntity = com.example.springboot.entities.Contrat.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Contrat> contrats;
   @ManyToMany(cascade=CascadeType.ALL)
    private Set<Team> equipes;

    }


package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="t_team")
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
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "team_id")
    private DetailTeam detailEquipe;
    @ManyToMany(cascade=CascadeType.ALL,mappedBy="equipes")
    private Set<Etudiant> etudiants;
}

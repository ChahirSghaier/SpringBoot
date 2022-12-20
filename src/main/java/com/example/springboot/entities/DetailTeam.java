package com.example.springboot.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_detail_team")
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
@ToString
public class DetailTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idDetail;
    private String salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe", cascade = CascadeType.ALL)
    private Team equipe;

}

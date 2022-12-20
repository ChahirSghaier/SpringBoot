package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_university")
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
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomUniv;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Departement> departement ;

    public void add(Departement item) {

        if (item != null) {
            if (departement == null) {
                departement = new HashSet<>();
            }

            departement.add(item);
        }
    }

}

package com.example.springboot.repository;

import com.example.springboot.entities.Etudiant;
import com.example.springboot.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EtudiantRepos extends JpaRepository<Etudiant, Integer> {

    List<Etudiant> findEtudiantByDepartement(String department);

    List<Etudiant> findByEquipes(String equipes);

    @Query(value="select * from t_student "+
    "where t_student.id=:id",nativeQuery = true)
     Etudiant findEtudiantById(Integer id);
    /**
     *  Native SQL
     * @apiNote on cherche les étudiants qui ont un contrat dont sa speciality est CLOUD
     * @param CLOUD
     * @return
     *
     */

    @Query(value=" select * from t_student student "+
            " join t_student_contrats student_contrat "+
            " on  student.id=student_contrat.etudiant_id"+
            " join t_contract contrat"+
            " on contrat.id=student_contrat.contrats_id"+
            " where contrat.specialites=: CLOUD "
            ,nativeQuery = true)
    List<Etudiant> findByContratsSpeciality(Specialite CLOUD);


    /**
     * JPQL
     * @param CLOUD
     * @return
     */
    @Query(" select e from Etudiant e inner join e.contrats c where c.specialites=:CLOUD ")
    List<Etudiant> findByContratsSpecialityDev(Specialite CLOUD);

    @Modifying
    @Query("DELETE FROM Etudiant e WHERE e.id= :idEtudiant")
    void delete(Integer idEtudiant);
   Etudiant findEtudiantByNomAndPrenom(String nom,String prenom);

}

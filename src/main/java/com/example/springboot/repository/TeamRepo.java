package com.example.springboot.repository;

import com.example.springboot.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {

    @Override
     List<Team> findAll();
     Team findTeamById(Long id);

    @Transactional
    @Modifying
    @Query("update Team t set t.nomEquipe=?1,t.option=?2,t.detailEquipe=?3,t.etudiants=?4")
     Team updateTeam(Team team);

   @Query("select t from Team t where t.id=?1")
   Set<Team> findTeamsById(Long valueOf);
}

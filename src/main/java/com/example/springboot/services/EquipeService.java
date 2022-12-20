package com.example.springboot.services;

import com.example.springboot.entities.Team;
import com.example.springboot.repository.TeamRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService{
     TeamRepo teamRepo;



    @Override
    public List<Team> retrieveAllTeams() {
        List<Team> teams; 
        teams= teamRepo.findAll();
        return teams;
    }

    @Override
    public Team retrieveTeam(Long teamId) {
        Team team;
        team=teamRepo.findTeamById(teamId);
        return team;
    }

    @Override
    public Team addTeam(Team team) {
        Team t ;
        t=teamRepo.save(team);
        return t;
    }

    @Override
    public void deleteTeam(Long teamId) {
       teamRepo.deleteById(teamId);

    }



    @Transactional
    public void update(Team team) {
        teamRepo
                .findById(team.getId()) // returns Optional<Team>
                .ifPresent(team1 -> {
                    team1.setNomEquipe(team1.getNomEquipe());
                    team1.setOption(team1.getOption());
                    team1.setDetailEquipe(team1.getDetailEquipe());
                    teamRepo.save(team1);
                });
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepo.updateTeam(team);
    }


}


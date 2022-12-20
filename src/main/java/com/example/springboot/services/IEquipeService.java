package com.example.springboot.services;

import com.example.springboot.entities.Team;

import java.util.List;

public interface IEquipeService {
    public List<Team> retrieveAllTeams();

    Team retrieveTeam(Long teamId);

    Team addTeam(Team team);

    void deleteTeam(Long teamId);
     void update(Team team) ;

    Team updateTeam(Team team);
}

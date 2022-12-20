package com.example.springboot.controller;

import com.example.springboot.entities.Team;
import com.example.springboot.services.IEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/team")

 public class EquipeController{

    private IEquipeService equipeService;

   @GetMapping("/retrieve-all-teams")
    public List<Team> getTeams() {
        List<Team> etudiantList ;
        etudiantList= equipeService.retrieveAllTeams();
        return etudiantList;
    }
    // http://localhost:8082/chahir/team/retrieve-team/1
    @GetMapping("/retrieve-team/{id}")
    public Team retrieveTeam(@PathVariable("id") Long teamId) {
        Team team;
        team = equipeService.retrieveTeam(teamId);
        return team;
    }

    // http://localhost:8082/chahir/team/add-team
    @PostMapping("/add-team")
    public Team addTeam(@RequestBody Team team) {

        Team equipe = equipeService.addTeam(team);
        return equipe;
    }

    // http://localhost:8082/chahir/team/remove-team/1
    @DeleteMapping("/remove-team/{id}")
    public void removeTeam(@PathVariable("id") Long TeamId)
    {
        equipeService.deleteTeam(TeamId);
    }

    // http://localhost:8082/chahir/team/update-team
    @PutMapping("/update-team")
    public void updateEtudiant(@RequestBody Team team) {
        equipeService.update(team);
    }


}

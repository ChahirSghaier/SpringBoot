package com.example.springboot.controller;

import com.example.springboot.entities.Contrat;
import com.example.springboot.services.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value="/contract" )
public class ContratController {

    IContratService contratService;

@GetMapping("/retrieve-all-contracts")
public List<Contrat> getAllContrat(){
    List<Contrat> contrats;
    contrats=contratService.retrieveAllContrats();
    return contrats;
}

@PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c){
    Contrat contrat;
    contrat=contratService.updateContrat(c);
    return contrat;
}

@PostMapping("/add-contract")
    public Contrat addNewContrat(@RequestBody Contrat c){
    Contrat contract ;
    contract= contratService.addContrat(c);
    return contract;
}
@GetMapping("/retrieve-contrat/{id}")
    public Contrat findContratById(@PathVariable(value="id") Integer id){

    return contratService.retrieveContrat(id);

}

@DeleteMapping("/delete/{id}")
    public void deleteContrat(@PathVariable(value="id") Integer id){
     contratService.removeContrat(id);
}

@PutMapping("/assign-contract-to-student/{idContrat}/{nomE}/{prenomE}")
public Contrat affectContratToEtudiant(@PathVariable(value="idContrat")Integer idContrat, @PathVariable(value="nomE")String nomE,@PathVariable(value="prenomE") String prenomE){
    return contratService.affectContratToEtudiant(idContrat,nomE,prenomE);
}

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CoachService;
import com.example.demo.service.PokemonService;

@RestController
public class ControllerRest {
 @Autowired
 private PokemonService pokemonService;
 
 @Autowired
 private CoachService coachService;
 
 @GetMapping("coach/getAllCoaches")
 public ResponseEntity<List<Coach>> getAllCoaches(){
	 return  ResponseEntity.status(HttpStatus.OK).body(coachService.getAllCoaches());
 }
 
 @GetMapping("coach/getCoachByName")
 public ResponseEntity<List<Coach>> getCoachByName(@RequestParam String name){
	 return  ResponseEntity.status(HttpStatus.OK).body(coachService.getCoachByName(name));
 }
 
 @GetMapping("coach/getAllCoachesWithPokes")
 public ResponseEntity<List> getAllCoachesWithPokes(){
	 return  ResponseEntity.status(HttpStatus.OK).body(coachService.getAllCoachesWithPokes());
 }
 
 @PatchMapping("coach/asignPokemonToCoach")
 public void asignPokemonToCoach(@RequestParam long idPokemon,@RequestParam long idCoach){
	 coachService.asignPokemonToCoach(idPokemon,idCoach);
 }
 
 @PatchMapping("coach/desasignPokemonToCoach")
 public void desasignPokemonToCoach(@RequestParam long idPokemon){
	 coachService.desasignPokemonToCoach(idPokemon);
 }
 
 @PostMapping("coach/createCoach")
 public ResponseEntity<Void> createCoach(@RequestBody Coach coach){
	 coachService.createCoach(coach);
	 return ResponseEntity.status(HttpStatus.CREATED).build();
 }
 
 @DeleteMapping("coach/deleteCoach")
 public ResponseEntity<Void> deleteCoach(@RequestParam long idCoach){
	 coachService.deleteCoach(idCoach);
	 return ResponseEntity.status(HttpStatus.OK).build();
 }
 
 @GetMapping("pokemon/getAllPokemons")
 public ResponseEntity<List<Pokemon>> getAllPokemons(){
	 return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAllPokemons());
 }
 
 @GetMapping("pokemon/getAllWildPokemons")
 public ResponseEntity<List<Pokemon>> getAllWildPokemons(){
	 return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAllWildPokemons());
 }
 
 @GetMapping("pokemon/getPokemonById")
 public ResponseEntity<Pokemon> getPokemonById(@RequestParam long idPokemon){
	 return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getPokemonById(idPokemon));
 }
 
 @PostMapping("pokemon/createPokemon")
 public ResponseEntity<Void> createPokemon(@RequestBody Pokemon pokemon){
	 pokemonService.createPokemon(pokemon);
	 return ResponseEntity.status(HttpStatus.CREATED).build();
 }
 
 @DeleteMapping("pokemon/deletePokemon")
 public ResponseEntity<Void> deletePokemon(@RequestParam long idPokemon){
	 pokemonService.deletePokemon(idPokemon);
	 return ResponseEntity.status(HttpStatus.OK).build();
 }
}

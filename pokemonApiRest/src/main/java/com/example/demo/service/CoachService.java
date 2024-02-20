package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Coach;
import com.example.demo.controller.Pokemon;
import com.example.demo.mapper.CoachMapper;
import com.example.demo.mapper.PokemonMapper;
import com.example.demo.repository.CoachRepository;
import com.example.demo.repository.PokemonRepository;

@Service
public class CoachService {
 @Autowired
 private CoachMapper coachMapper;
 
 @Autowired
 private CoachRepository coachRepository;
 
 @Autowired
 private PokemonMapper pokemonMapper;
 
 @Autowired
 private PokemonRepository pokemonRepository;
 
 @Autowired
 private PokemonService pokemonService;
 
 public List<Coach> getAllCoaches() {
	 return coachMapper.CoachEntityListToCoachList(coachRepository.findAll());
 }
 
 public List getAllCoachesWithPokes() {
	 List<Coach> coaches =  coachMapper.CoachEntityListToCoachList(coachRepository.findAll());
	 List<Pokemon> pokemons =pokemonMapper.PokemonEntityListToPokemonList(pokemonRepository.findAll());
	 List resultado= new ArrayList<>();
	 for(Coach coach: coaches) {
		 resultado.add(coach);
		 for(Pokemon poke:pokemons) {
			 if(!(poke.getCoach()==null)){
			 if(poke.getCoach().getId()==coach.getId()) {
				 resultado.add(poke);
			 }
			 }
		 }
	 }
	 
	 return resultado;
 }
 
 public List<Coach> getCoachByName(String name){
	 List<Coach> coaches=coachMapper.CoachEntityListToCoachList(coachRepository.findAll());
	 List<Coach> coachesByName= new ArrayList<>();
	 for(Coach coach :coaches) {
		 if(coach.getName().equalsIgnoreCase(name)) {
			 coachesByName.add(coach);
		 }
	 }
	 if(coachesByName.size()==0) {
		 return coachesByName;
	 }
	 return coachesByName;
 }
 
 public void asignPokemonToCoach(long idPokemon, long idCoach) {
	 if(coachRepository.existsById(idCoach)) {
		 if(pokemonRepository.existsById(idPokemon)) {
			 Pokemon pkm= pokemonMapper.PokemonEntityToPokemon(pokemonRepository.getReferenceById(idPokemon));
			 Coach ch =coachMapper.CoachEntityToCoach(coachRepository.getReferenceById(idCoach));
			 if(pkm.getCoach()==null) {
			 pkm.setCoach(ch);
			 pokemonRepository.save(pokemonMapper.PokemonToPokemonEntity(pkm));
			 }
		 }
	 }
 }
 
 public void desasignPokemonToCoach(long idPokemon) {
		 if(pokemonRepository.existsById(idPokemon)) {
			 Pokemon pkm= pokemonMapper.PokemonEntityToPokemon(pokemonRepository.getReferenceById(idPokemon));
			 pkm.setCoach(null);
			 pokemonRepository.save(pokemonMapper.PokemonToPokemonEntity(pkm));
		 }
 }
 
 public void createCoach(Coach coach) {
	 coachRepository.save(coachMapper.CoachToCoachEntity(coach));
 }
 
 
 public void deleteCoach(long idCoach) {
	 
	 List<Pokemon> pokemons=pokemonService.getAllPokemons();
	 for(Pokemon poke:pokemons) {
		 if(!(poke.getCoach()==null)){
			 if(poke.getCoach().getId()==idCoach) {
				 desasignPokemonToCoach(poke.getId());	 
			 }
		 }
	 }
	 coachRepository.deleteById(idCoach);
 }
}

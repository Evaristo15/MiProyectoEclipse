package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Coach;
import com.example.demo.controller.Pokemon;
import com.example.demo.mapper.PokemonMapper;
import com.example.demo.repository.PokemonRepository;

@Service
public class PokemonService {
 @Autowired
 private PokemonMapper pokemonMapper;
 
 @Autowired
 private PokemonRepository pokemonRepository;
 
 
 public List<Pokemon> getAllPokemons(){
	 return pokemonMapper.PokemonEntityListToPokemonList(pokemonRepository.findAll());
 }
 
 public List<Pokemon> getAllWildPokemons(){
	 List<Pokemon> pokemons = pokemonMapper.PokemonEntityListToPokemonList(pokemonRepository.findAll());
	 List<Pokemon> wildPokemons= new ArrayList<>();
	 
	 for(Pokemon poke :pokemons) {
		 if(poke.getCoach()==null) {
			 wildPokemons.add(poke);
		 }
	 }
	 
	 return wildPokemons;
 }
 
 
 public Pokemon getPokemonById(long id) {
	 
	 return pokemonMapper.PokemonEntityToPokemon(pokemonRepository.getReferenceById(id));
	 
 }
 
 public void createPokemon(Pokemon pokemon){
	 
	 pokemonRepository.save(pokemonMapper.PokemonToPokemonEntity(pokemon));

 }
 
 public void deletePokemon(long idPokemon){
	 
	 Pokemon p1= getPokemonById(idPokemon);
	 p1.setCoach(null);
	 createPokemon(p1);
	 
	 pokemonRepository.deleteById(idPokemon);

 }
 
}

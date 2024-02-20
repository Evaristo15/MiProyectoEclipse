package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import com.example.demo.controller.Pokemon;
import com.example.demo.repository.PokemonEntity;

@Mapper(componentModel = "spring", uses = {CoachMapper.class})
public interface PokemonMapper {
	
	Pokemon PokemonEntityToPokemon(PokemonEntity pokemonEntity);
	PokemonEntity PokemonToPokemonEntity(Pokemon pokemon);
	List<Pokemon> PokemonEntityListToPokemonList (List<PokemonEntity> pokemonEntityList);
}

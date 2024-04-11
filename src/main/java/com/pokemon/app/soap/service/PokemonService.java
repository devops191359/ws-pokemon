package com.pokemon.app.soap.service;

import com.pokemon.app.rest.response.PokemonAbilitiesResponse;
import com.pokemon.app.rest.response.PokemonBaseExperienceResponse;
import com.pokemon.app.rest.response.PokemonHeldItemsResponse;
import com.pokemon.app.rest.response.PokemonIdResponse;
import com.pokemon.app.rest.response.PokemonLocationAreaResponse;
import com.pokemon.app.rest.response.PokemonNameResponse;

public interface PokemonService {
	
	
	public PokemonAbilitiesResponse getAbilitiesByPokemonName(String nombrePokemon) throws Exception;

	public PokemonBaseExperienceResponse getBaseExperienceByPokemonName(String nombrePokemon) throws Exception;

	public PokemonHeldItemsResponse getHeldItemsByPokemonName(String nombrePokemon) throws Exception;

	public PokemonIdResponse getIdByPokemonName(String nombrePokemon) throws Exception;

	public PokemonNameResponse getNameByPokemonName(String nombrePokemon) throws Exception;

	public PokemonLocationAreaResponse getLocationAreaEncByPokemonName(String nombrePokemon) throws Exception;

}

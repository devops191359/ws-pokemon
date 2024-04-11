package com.pokemon.app.rest.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PokemonAbilitiesResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private List<AbilityItemRest> abilities;

}

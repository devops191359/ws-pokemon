package com.pokemon.app.rest.response;

import java.io.Serializable;

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
public class PokemonBaseExperienceResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer base_experience;

}

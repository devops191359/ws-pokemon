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
public class AbilityItemRest implements Serializable{

	private AbilityRest ability;

	private boolean is_hidden;

	private Integer slot;

}

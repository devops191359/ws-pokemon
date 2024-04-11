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
public class VersionDetailItemRest implements Serializable {

	private Integer rarity;
	private VersionItemRest version;

}

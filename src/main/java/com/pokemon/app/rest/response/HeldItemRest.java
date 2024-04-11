
package com.pokemon.app.rest.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class HeldItemRest implements Serializable{

	private ItemObjRest item;
	private List<VersionDetailItemRest> version_details;

}

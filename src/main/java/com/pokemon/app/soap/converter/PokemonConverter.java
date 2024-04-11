package com.pokemon.app.soap.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.pokemon.app.rest.response.AbilityItemRest;
import com.pokemon.app.rest.response.AbilityRest;
import com.pokemon.app.rest.response.HeldItemRest;
import com.pokemon.app.rest.response.ItemObjRest;
import com.pokemon.app.gen.Ability;
import com.pokemon.app.gen.AbilityItem;
import com.pokemon.app.gen.HeldItem;
import com.pokemon.app.gen.ItemObj;
import com.pokemon.app.gen.VersionDetailItem;
import com.pokemon.app.gen.VersionItem;
import com.pokemon.app.rest.response.PokemonAbilitiesResponse;
import com.pokemon.app.rest.response.PokemonHeldItemsResponse;
import com.pokemon.app.rest.response.VersionDetailItemRest;
import com.pokemon.app.rest.response.VersionItemRest;

@Component
public class PokemonConverter {

	public Ability getAbility(AbilityRest ab) {
		Ability a = new Ability();
		a.setName(ab.getName());
		a.setUrl(ab.getUrl());
		return a;
	}

	public AbilityItem getAbilityItem(AbilityItemRest ab) {
		AbilityItem item = new AbilityItem();
		item.setIshidden(ab.is_hidden());
		item.setSlot(String.valueOf(ab.getSlot()));
		item.setAbility(getAbility(ab.getAbility()));
		return item;
	}

	public List<AbilityItem> getAbilities(PokemonAbilitiesResponse pokemonAbilitiesResponse) {
		List<AbilityItem> abilities = new ArrayList<>();
		pokemonAbilitiesResponse.getAbilities().forEach(ab -> {
			abilities.add(getAbilityItem(ab));
		});
		return abilities;
	}

	public List<HeldItem> getHeldsItems(PokemonHeldItemsResponse response) {

		List<HeldItem> healdsItems = new ArrayList<>();

		response.getHeld_items().forEach(hi -> {
			healdsItems.add(getHeldItem(hi));
		});

		return healdsItems;
	}

	public HeldItem getHeldItem(HeldItemRest hir) {
		HeldItem hi = new HeldItem();
		hi.setItem(getItemObj(hir.getItem()));
		hi.getVersionDetails().addAll(getVersionsDetails(hir.getVersion_details()));
		return hi;

	}

	public ItemObj getItemObj(ItemObjRest objRest) {

		ItemObj ob = new ItemObj();
		ob.setName(objRest.getName());
		ob.setUrl(objRest.getUrl());
		return ob;
	}

	public List<VersionDetailItem> getVersionsDetails(List<VersionDetailItemRest> vdir) {
		List<VersionDetailItem> versionsDetails = new ArrayList<>();
		vdir.forEach(vd -> {
			versionsDetails.add(getVersionDetail(vd));
		});
		return versionsDetails;
	}

	public VersionDetailItem getVersionDetail(VersionDetailItemRest vdr) {
		VersionDetailItem vdi = new VersionDetailItem();
		vdi.setRarity(String.valueOf(vdr.getRarity()));
		vdi.setVersion(getVersionItem(vdr.getVersion()));
		return vdi;
	}

	public VersionItem getVersionItem(VersionItemRest vir) {
		VersionItem vi = new VersionItem();
		vi.setName(vir.getName());
		vi.setUrl(vir.getUrl());
		return vi;
	}

}

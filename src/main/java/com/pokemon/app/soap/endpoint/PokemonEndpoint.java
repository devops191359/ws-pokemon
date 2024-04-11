package com.pokemon.app.soap.endpoint;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.pokemon.app.constantes.Constantes;
import com.pokemon.app.gen.GetAbilitiesRequest;
import com.pokemon.app.gen.GetAbilitiesResponse;
import com.pokemon.app.gen.GetBaseExperienceRequest;
import com.pokemon.app.gen.GetBaseExperienceResponse;
import com.pokemon.app.gen.GetHeldItemsRequest;
import com.pokemon.app.gen.GetHeldItemsResponse;
import com.pokemon.app.gen.GetIdRequest;
import com.pokemon.app.gen.GetIdResponse;
import com.pokemon.app.gen.GetLocationAreaEncountersRequest;
import com.pokemon.app.gen.GetLocationAreaEncountersResponse;
import com.pokemon.app.gen.GetNameRequest;
import com.pokemon.app.gen.GetNameResponse;
import com.pokemon.app.rest.response.PokemonAbilitiesResponse;
import com.pokemon.app.rest.response.PokemonBaseExperienceResponse;
import com.pokemon.app.rest.response.PokemonHeldItemsResponse;
import com.pokemon.app.rest.response.PokemonIdResponse;
import com.pokemon.app.rest.response.PokemonLocationAreaResponse;
import com.pokemon.app.rest.response.PokemonNameResponse;
import com.pokemon.app.service.BitacoraService;
import com.pokemon.app.soap.converter.PokemonConverter;
import com.pokemon.app.soap.model.TrazaModel;
import com.pokemon.app.soap.service.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
@RequiredArgsConstructor
public class PokemonEndpoint {

	private static final String NAMESPACE_URI = "http://pokeapi.co/ws-pokemon";

	private final PokemonService pokemonService;

	private final PokemonConverter pokemonConverter;

	private final HttpServletRequest requestP;

	private final BitacoraService bitacoraService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
	@ResponsePayload
	public GetAbilitiesResponse getAbilitiesByPokemon(@RequestPayload GetAbilitiesRequest request) throws Exception {

		String ipAddress = requestP.getHeader(Constantes.HEADER_X_FORWARDED);
		if (ipAddress == null) {
			ipAddress = requestP.getRemoteAddr();
		}
		this.saveTraza(ipAddress, request, Constantes.METHOD_GET_ABILITIES);

		GetAbilitiesResponse response = new GetAbilitiesResponse();
		PokemonAbilitiesResponse responseService = pokemonService.getAbilitiesByPokemonName(request.getPokemon());
		response.setName(responseService.getName());
		response.getAbilities().addAll(pokemonConverter.getAbilities(responseService));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
	@ResponsePayload
	public GetBaseExperienceResponse getBaseExperienceByPokemon(@RequestPayload GetBaseExperienceRequest request)
			throws Exception {
		
		String ipAddress = requestP.getHeader(Constantes.HEADER_X_FORWARDED);
		if (ipAddress == null) {
			ipAddress = requestP.getRemoteAddr();
		}
		this.saveTraza(ipAddress, request, Constantes.METHOD_GET_BASE_EXPERIENCE);
		
		GetBaseExperienceResponse response = new GetBaseExperienceResponse();
		PokemonBaseExperienceResponse responseService = pokemonService
				.getBaseExperienceByPokemonName(request.getPokemon());
		response.setBaseExperience(String.valueOf(responseService.getBase_experience()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
	@ResponsePayload
	public GetHeldItemsResponse getHeldItemsByPokemon(@RequestPayload GetHeldItemsRequest request) throws Exception {
		
		String ipAddress = requestP.getHeader(Constantes.HEADER_X_FORWARDED);
		if (ipAddress == null) {
			ipAddress = requestP.getRemoteAddr();
		}
		this.saveTraza(ipAddress, request, Constantes.METHOD_GET_HELD_ITEMS);
		GetHeldItemsResponse response = new GetHeldItemsResponse();
		PokemonHeldItemsResponse responseService = pokemonService.getHeldItemsByPokemonName(request.getPokemon());
		response.getHeldItems().addAll(pokemonConverter.getHeldsItems(responseService));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
	@ResponsePayload
	public GetIdResponse getIdByPokemon(@RequestPayload GetIdRequest request) throws Exception {
		
		String ipAddress = requestP.getHeader(Constantes.HEADER_X_FORWARDED);
		if (ipAddress == null) {
			ipAddress = requestP.getRemoteAddr();
		}
		this.saveTraza(ipAddress, request, Constantes.METHOD_GET_ID);
		GetIdResponse response = new GetIdResponse();
		PokemonIdResponse responseService = pokemonService.getIdByPokemonName(request.getPokemon());
		response.setId(responseService.getId().intValue());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public GetNameResponse getNameByPokemon(@RequestPayload GetNameRequest request) throws Exception {
		String ipAddress = requestP.getHeader(Constantes.HEADER_X_FORWARDED);
		if (ipAddress == null) {
			ipAddress = requestP.getRemoteAddr();
		}
		this.saveTraza(ipAddress, request, Constantes.METHOD_GET_NAME);
		GetNameResponse response = new GetNameResponse();
		PokemonNameResponse responseService = pokemonService.getNameByPokemonName(request.getPokemon());
		response.setName(responseService.getName());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
	@ResponsePayload
	public GetLocationAreaEncountersResponse getLocationAreaEncountersByPokemon(
			@RequestPayload GetLocationAreaEncountersRequest request) throws Exception {
		String ipAddress = requestP.getHeader(Constantes.HEADER_X_FORWARDED);
		if (ipAddress == null) {
			ipAddress = requestP.getRemoteAddr();
		}
		this.saveTraza(ipAddress, request, Constantes.METHOD_GET_LOCATION_AREA_ENCOUNTERS);
		GetLocationAreaEncountersResponse response = new GetLocationAreaEncountersResponse();
		PokemonLocationAreaResponse responseService = pokemonService
				.getLocationAreaEncByPokemonName(request.getPokemon());
		response.setLocationAreaEncounters(responseService.getLocation_area_encounters());
		return response;
	}

	private void saveTraza(String ipAddress,Object request, String metodo) {
		TrazaModel tr = new TrazaModel();
		tr.setRequestBody(request);
		tr.setIpOrigen(ipAddress);
		tr.setMetodo(metodo);
		tr.setFechaTransaccion(new SimpleDateFormat(Constantes.FORMAT_DATE_STR).format(new Date()));
		log.info("log traza : "+tr);   
		Object obj = this.bitacoraService.saveTransaccion(tr);
	}

}

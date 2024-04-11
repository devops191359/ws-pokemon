package com.pokemon.app.soap.service;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pokemon.app.rest.response.PokemonAbilitiesResponse;
import com.pokemon.app.rest.response.PokemonBaseExperienceResponse;
import com.pokemon.app.rest.response.PokemonHeldItemsResponse;
import com.pokemon.app.rest.response.PokemonIdResponse;
import com.pokemon.app.rest.response.PokemonLocationAreaResponse;
import com.pokemon.app.rest.response.PokemonNameResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

	@Value("${app.pokemon.ws.rest.url}")
	private String urlPokemon;
	

	@Override
	public PokemonAbilitiesResponse getAbilitiesByPokemonName(String nombrePokemon) throws Exception {
		PokemonAbilitiesResponse response = new PokemonAbilitiesResponse();
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<PokemonAbilitiesResponse> responseEntity = restTemplate.exchange(urlPokemon, HttpMethod.GET,
				null, PokemonAbilitiesResponse.class, nombrePokemon);
		response = responseEntity.getBody();
		return response;
	}

	@Override
	public PokemonBaseExperienceResponse getBaseExperienceByPokemonName(String nombrePokemon) throws Exception {
		PokemonBaseExperienceResponse response = new PokemonBaseExperienceResponse();
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<PokemonBaseExperienceResponse> responseEntity = restTemplate.exchange(urlPokemon, HttpMethod.GET,
				null, PokemonBaseExperienceResponse.class, nombrePokemon);
		response = responseEntity.getBody();
		return response;
	}
	
	@Override
	public PokemonHeldItemsResponse getHeldItemsByPokemonName(String nombrePokemon) throws Exception {
		PokemonHeldItemsResponse response = new PokemonHeldItemsResponse();
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<PokemonHeldItemsResponse> responseEntity = restTemplate.exchange(urlPokemon, HttpMethod.GET,
				null, PokemonHeldItemsResponse.class, nombrePokemon);
		response = responseEntity.getBody();
		return response;
	}
	
	@Override
	public PokemonIdResponse getIdByPokemonName(String nombrePokemon) throws Exception {
		PokemonIdResponse response = new PokemonIdResponse();
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<PokemonIdResponse> responseEntity = restTemplate.exchange(urlPokemon, HttpMethod.GET,
				null, PokemonIdResponse.class, nombrePokemon);
		response = responseEntity.getBody();
		return response;
	}
	
	
	@Override
	public PokemonNameResponse getNameByPokemonName(String nombrePokemon) throws Exception {
		PokemonNameResponse response = new PokemonNameResponse();
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<PokemonNameResponse> responseEntity = restTemplate.exchange(urlPokemon, HttpMethod.GET,
				null, PokemonNameResponse.class, nombrePokemon);
		response = responseEntity.getBody();
		return response;
	}
	
	
	@Override
	public PokemonLocationAreaResponse getLocationAreaEncByPokemonName(String nombrePokemon) throws Exception {
		PokemonLocationAreaResponse response = new PokemonLocationAreaResponse();
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<PokemonLocationAreaResponse> responseEntity = restTemplate.exchange(urlPokemon, HttpMethod.GET,
				null, PokemonLocationAreaResponse.class, nombrePokemon);
		response = responseEntity.getBody();
		return response;
	}

	// Method to get a RestTemplate with SSL verification disabled
	public RestTemplate getRestTemplate() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContext.getInstance("TLS");
		TrustManager[] trustManagers = new TrustManager[] { new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
			}

			public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		} };
		sslContext.init(null, trustManagers, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
		RestTemplate restTemplate = new RestTemplateBuilder().requestFactory(SimpleClientHttpRequestFactory.class)
				.build();

		return restTemplate; // Return the configured RestTemplate
	}
}

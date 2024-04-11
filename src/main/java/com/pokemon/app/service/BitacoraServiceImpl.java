package com.pokemon.app.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pokemon.app.dao.BitacoraDAO;
import com.pokemon.app.entity.BitacoraEntity;
import com.pokemon.app.soap.model.TrazaModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BitacoraServiceImpl implements BitacoraService {

	private final BitacoraDAO bitacoraDAO;

	@Override
	public Object saveTransaccion(TrazaModel tm) {

		Gson gson = new Gson();
		BitacoraEntity be = new BitacoraEntity();
		be.setIpOrigen(tm.getIpOrigen());
		be.setFechaRequest(tm.getFechaTransaccion());
		be.setMetodoEjecucion(tm.getMetodo());
		be.setTrazaJson(gson.toJson(tm));
		be = this.bitacoraDAO.saveAndFlush(be);

		return be;
	}

}

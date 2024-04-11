package com.pokemon.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pokemon.app.entity.BitacoraEntity;

public interface BitacoraDAO extends CrudRepository<BitacoraEntity, Integer>, JpaRepository<BitacoraEntity, Integer> {

}

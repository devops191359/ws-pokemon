package com.pokemon.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TA_BITACORA")
public class BitacoraEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FIIDTRAN", unique = true)
	private Integer idTransaccion;

	@Column(name = "FIIPORIGEN", nullable = false, length = 200)
	private String ipOrigen;

	@Column(name = "FCFECHAREQ", nullable = false, length = 200)
	private String fechaRequest;

	@Column(name = "FCMETODOEJ", nullable = false, length = 200)
	private String metodoEjecucion;
	
	
	@Column(name = "FCTRAZA", nullable = false, length = 200)
	private String trazaJson;

}

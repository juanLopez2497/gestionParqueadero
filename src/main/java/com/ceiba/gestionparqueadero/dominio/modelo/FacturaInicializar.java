package com.ceiba.gestionparqueadero.dominio.modelo;

import java.time.LocalDateTime;

public class FacturaInicializar {
	private static final String ID_ACT_OBLIGATORIO = "error, el id es obligatorio.";
	private Long id;
	private LocalDateTime fechaSalida;
	
	public FacturaInicializar(Long id){
		ValidadorCampos.validarNonNull(id, ID_ACT_OBLIGATORIO);
		this.fechaSalida = LocalDateTime.now();
		this.id=id;
	}
	public FacturaInicializar(Long id, LocalDateTime fechaSalida){
		this.fechaSalida = fechaSalida;
		this.id=id;
	}

	public Long getId() {
		return id;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}	
}

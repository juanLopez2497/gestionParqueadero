package com.ceiba.gestionparqueadero.dominio;

import java.time.LocalDateTime;

public class FacturaInicializar {
	private Long id;
	private LocalDateTime fechaSalida;
	
	public FacturaInicializar(Long id){
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

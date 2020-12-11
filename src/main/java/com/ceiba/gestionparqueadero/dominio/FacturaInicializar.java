package com.ceiba.gestionparqueadero.dominio;

import java.time.LocalDateTime;

public class FacturaInicializar {
	private Long id;
	private String placa;
	private String flagBonoDescuento;
	private LocalDateTime fechaSalida;
	
	public FacturaInicializar(Long id, String placa, String flagBonoDescuento){
		this.fechaSalida = LocalDateTime.now();
		this.id=id;
		this.placa=placa;
		this.flagBonoDescuento=flagBonoDescuento;
	}

	public Long getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public String getFlagBonoDescuento() {
		return flagBonoDescuento;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}	
}

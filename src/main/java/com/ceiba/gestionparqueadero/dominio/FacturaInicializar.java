package com.ceiba.gestionparqueadero.dominio;

import java.util.Date;

public class FacturaInicializar {
	private Long id;
	private String placa;
	private String flagBonoDescuento;
	private Date fechaSalida;
	
	public FacturaInicializar(Long id, String placa, String flagBonoDescuento){
		this.fechaSalida=new Date();
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

	public Date getFechaSalida() {
		return fechaSalida;
	}
}

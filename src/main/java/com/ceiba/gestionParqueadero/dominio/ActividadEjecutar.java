package com.ceiba.gestionParqueadero.dominio;

import java.util.Date;

public class ActividadEjecutar {
	private String placa;
	private String anotacion;
	private Date fechaEntra;
	private String tipo;
	
	public ActividadEjecutar(String placa, String anotacion, String tipo){
		this.fechaEntra = new Date();
		this.anotacion=anotacion;
		this.placa=placa;
		this.tipo=tipo;
	}
	
	public String getPlaca() {
		return placa;
	}
	public String getAnotacion() {
		return anotacion;
	}
	
	public Date getFechaEntra() {
		return fechaEntra;
	}

	public String getTipo() {
		return tipo;
	}
	
	
}

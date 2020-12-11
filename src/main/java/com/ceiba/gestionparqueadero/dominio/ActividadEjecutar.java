package com.ceiba.gestionparqueadero.dominio;

import java.time.LocalDateTime;

public class ActividadEjecutar {
	private String placa;
	private String anotacion;
	private LocalDateTime fechaEntra;
	private String tipo;
	
	public ActividadEjecutar(String placa, String anotacion, String tipo){
		this.fechaEntra = LocalDateTime.now();
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
	public LocalDateTime getFechaEntra() {
		return fechaEntra;
	}
	public String getTipo() {
		return tipo;
	}	
}

package com.ceiba.gestionparqueadero.dominio.modelo;

import java.time.LocalDateTime;

public class ActividadEjecutar {
	
	private static final String PLACA_OBLIGATORIO = "error, la placa obligatoria.";
	private static final String TPO_OBLIGATORIO = "error, el tipo es obligatorio.";
	private static final String BONO_OBLIGATORIO = "error, pregunta de bono obligatoria.";
	
	private String placa;
	private String anotacion;
	private LocalDateTime fechaEntra;
	private String tipo;
	private String bono;
	
	public ActividadEjecutar(String placa, String anotacion, String tipo, String bono){
		ValidadorCampos.validarNonNull(placa, PLACA_OBLIGATORIO);
		ValidadorCampos.validarNonNull(tipo, TPO_OBLIGATORIO);
		ValidadorCampos.validarNonNull(bono, BONO_OBLIGATORIO);
		this.fechaEntra = LocalDateTime.now();
		this.anotacion=anotacion;
		this.placa=placa;
		this.tipo=tipo;
		this.bono=bono;
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
	public String getBono() {
		return bono;
	}
	
}

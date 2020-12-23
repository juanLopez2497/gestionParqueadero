package com.ceiba.gestionparqueadero.dominio.dto;

import java.time.LocalDateTime;

public class ActividadResumenDTO {
	
	private LocalDateTime horaEntra;
	
	private String placa;
	
	private String anotacion;
	
	private String tipo;
	
	private Long idActRegistro;
	
	private String bono;
	
	public ActividadResumenDTO(LocalDateTime horaEntra, String placa, String anotacion, String tipo, 
			Long idActRegistro, String bono) {
		this.horaEntra=horaEntra;
		this.placa=placa;
		this.anotacion=anotacion;
		this.tipo=tipo;
		this.idActRegistro=idActRegistro;
		this.bono=bono;
	}
	
	public LocalDateTime getHoraEntra() {
		return horaEntra;
	}
	public String getPlaca() {
		return placa;
	}
	public String getAnotacion() {
		return anotacion;
	}
	public String getTipo() {
		return tipo;
	}
	public Long getIdActRegistro() {
		return idActRegistro;
	}
	public String getBono() {
		return bono;
	}	
}

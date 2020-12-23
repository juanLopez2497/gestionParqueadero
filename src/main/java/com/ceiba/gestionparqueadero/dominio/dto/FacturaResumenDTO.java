package com.ceiba.gestionparqueadero.dominio.dto;

public class FacturaResumenDTO {
	
	private Long idAct;
	
	private String placa;
	
	private double valorPagado;
	
	public FacturaResumenDTO(Long idAct, String placa, double valorPagado){
		this.idAct=idAct;
		this.placa=placa;
		this.valorPagado=valorPagado;
	}
	
	public Long getIdAct() {
		return idAct;
	}


	public String getPlaca() {
		return placa;
	}

	public double getValorPagado() {
		return valorPagado;
	}
}

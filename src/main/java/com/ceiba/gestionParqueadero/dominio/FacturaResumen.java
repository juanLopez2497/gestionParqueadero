package com.ceiba.gestionParqueadero.dominio;

public class FacturaResumen {
	
	private Long idAct;
	
	private String placa;
	
	private double ValorPagado;
	
	public FacturaResumen(Long idAct, String placa, double ValorPagado){
		this.idAct=idAct;
		this.placa=placa;
		this.ValorPagado=ValorPagado;
	}
	
	public Long getIdAct() {
		return idAct;
	}


	public String getPlaca() {
		return placa;
	}

	public double getValorPagado() {
		return ValorPagado;
	}
}

package com.ceiba.gestionparqueadero.aplicacion.comando;

public class ComandoGeneracionFactura {
	private Long id;
	private String placa;
	private String flagBonoDescuento;
	
	public ComandoGeneracionFactura(){
		super();
	}
	public ComandoGeneracionFactura(Long id, String placa, String flagBonoDescuento){
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
}

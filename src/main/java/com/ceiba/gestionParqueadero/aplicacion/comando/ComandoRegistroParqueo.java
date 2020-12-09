package com.ceiba.gestionParqueadero.aplicacion.comando;

public class ComandoRegistroParqueo {
	
	private String placa;
	private String anotacion;
	private String tipo;
	
	public ComandoRegistroParqueo(){
		super();
	}
	
	public ComandoRegistroParqueo(String placa, String anotacion, String tipo){
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
	public String getTipo() {
		return tipo;
	}
}

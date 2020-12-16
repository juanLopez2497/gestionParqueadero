package com.ceiba.gestionparqueadero.aplicacion.comando;

public class ComandoRegistroParqueo {
	
	private String placa;
	private String anotacion;
	private String tipo;
	private String bono;
	
	public ComandoRegistroParqueo(){
		super();
	}
	
	public ComandoRegistroParqueo(String placa, String anotacion, String tipo, String bono){
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
	public String getTipo() {
		return tipo;
	}

	public String getBono() {
		return bono;
	}
	
}

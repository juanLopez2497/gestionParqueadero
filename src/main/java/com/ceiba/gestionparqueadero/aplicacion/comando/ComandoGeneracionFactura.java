package com.ceiba.gestionparqueadero.aplicacion.comando;

public class ComandoGeneracionFactura {
	private Long id;
	
	public ComandoGeneracionFactura(){
		super();
	}
	public ComandoGeneracionFactura(Long id){
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}
}

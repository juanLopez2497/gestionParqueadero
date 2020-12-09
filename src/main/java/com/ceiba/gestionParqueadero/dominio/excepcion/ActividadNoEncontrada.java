package com.ceiba.gestionParqueadero.dominio.excepcion;

public class ActividadNoEncontrada extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 647254303096740391L;
	
	public ActividadNoEncontrada(String mensaje){
		super(mensaje);
	}

}
